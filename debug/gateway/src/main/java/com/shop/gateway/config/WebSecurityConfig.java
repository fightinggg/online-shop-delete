package com.shop.gateway.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.common.ResponseJSON;
import com.shop.common.StateCode;
import com.shop.gateway.dao.RoleUrlDao;
import com.shop.gateway.dao.UserDao;
import com.shop.gateway.dao.UserRoleDao;
import org.bouncycastle.util.Strings;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.WebSession;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.NonBlocking;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Configuration
@EnableWebFluxSecurity
//https://www.cnblogs.com/tangyouwei/p/10032668.html
public class WebSecurityConfig {

    // 注入hash加密算法
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 注入用户细节
    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService() {
        return new ReactiveUserDetailsService() {
            @Autowired
            UserRoleDao userRoleDao;

            @Autowired
            UserDao userDao;

            @Override
            public Mono<UserDetails> findByUsername(String username) {
                int id = 0;
                try {
                    id = Integer.parseInt(username);
                } catch (Exception e) {
                    return Mono.empty();
                }
                com.shop.gateway.entity.User user = userDao.selectByPrimaryKey(id);
                if (user == null) {
                    return Mono.empty();
                }
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for (String role : userRoleDao.selectRoleByUserId(id)) {
                    authorities.add(new SimpleGrantedAuthority(role));
                }
                UserDetails result = new User(username, user.getPassword(), authorities);
                return Mono.just(User.withUserDetails(result).build());
            }
        };
    }

    @Autowired
    RoleUrlDao roleUrlDao;

    Mono<Void> returnMsg(WebFilterExchange webFilterExchange, String str) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        //设置headers
        HttpHeaders headers = response.getHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        if (CorsUtils.isCorsRequest(exchange.getRequest())) {
            System.out.println(exchange.getRequest().getHeaders().getOrigin());
            headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, exchange.getRequest().getHeaders().getOrigin());
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "");
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
            headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
            if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
                response.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }
        }
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(str.getBytes());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        http.cors().disable();
        http.csrf().disable();
        http.formLogin()
                .authenticationSuccessHandler((webFilterExchange, authentication) -> returnMsg(webFilterExchange, "登陆成功"))
                .authenticationFailureHandler((webFilterExchange, exception) -> returnMsg(webFilterExchange, "登陆失败"));

        http.logout().
                logoutUrl("/logout").logoutSuccessHandler((exchange, authentication) -> returnMsg(exchange, "登出成功"));


        // 定制url匹配规则
        http.authorizeExchange().anyExchange().access((authentication, object) -> {
            HttpRequest httpRequest = object.getExchange().getRequest();

            StringBuilder preUrl = new StringBuilder(httpRequest.getMethodValue());
            preUrl.append("/");
            String[] urls = httpRequest.getURI().getPath().split("/");
            for (int i = 1; i < urls.length; i++) {
                String url = urls[i];
                Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                if (pattern.matcher(url).matches()) break;
                else preUrl.append(url).append("/");
            }
            List<String> needRoles = roleUrlDao.selectRoleByUrl(preUrl.toString());

            // toruist资源可被任何人访问
            if (needRoles.contains("ROLE_TOURIST")) {
                return Mono.just(new AuthorizationDecision(true));
            } else {
                return authentication.map((o) -> {
                    List<String> haveRoles = o.getAuthorities()
                            .stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList());
                    System.out.println(httpRequest.getURI() + "    " + preUrl + "    " + needRoles + haveRoles);
                    for (String haveRole : haveRoles) {
                        // root可访问所有资源
                        if (haveRole.equals("ROLE_ROOT") || needRoles.contains(haveRole)) {
                            return new AuthorizationDecision(true);
                        }
                    }
                    return new AuthorizationDecision(false);
                }).defaultIfEmpty(new AuthorizationDecision(false));
            }

        });


        // add id
        http.addFilterAt((exchange, chain) -> {
            // TODO BUG ERROR !!!!!!! subscribe is not suteble here
            exchange.getSession()
                    .map(WebSession::getAttributes)
                    .filter(o -> o.containsKey("SPRING_SECURITY_CONTEXT"))
                    .map(o -> o.get("SPRING_SECURITY_CONTEXT"))
                    .cast(SecurityContext.class)
                    .map(SecurityContext::getAuthentication)
                    .map(Authentication::getPrincipal)
                    .cast(UserDetails.class)
                    .map(UserDetails::getUsername)
                    .doOnSuccess(s -> exchange.getRequest().mutate().header("id", s))
                    .subscribe();
            return chain.filter(exchange);
        }, SecurityWebFiltersOrder.LAST);

        // deal with cors
        http.addFilterAt((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = exchange.getResponse();
                HttpHeaders headers = response.getHeaders();
                System.out.println(request.getHeaders().getOrigin());
                headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeaders().getOrigin());
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "");
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
                headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
                headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(exchange);
        }, SecurityWebFiltersOrder.SECURITY_CONTEXT_SERVER_WEB_EXCHANGE);


        http.httpBasic().authenticationEntryPoint((exchange, e) -> {
            exchange.getResponse().setStatusCode(HttpStatus.OK);
            String json;
            switch (e.getMessage()) {
                case "Not Authenticated":
                    json = ResponseJSON.encode(StateCode.NO_AUTHENTICATED, "没有登陆哦小兄弟！");
                    break;
                default:
                    json = ResponseJSON.encode(StateCode.UNKNOWN_SREVER_ERROR, e.getMessage());
                    break;
            }
            byte[] bytes = json.getBytes();
            DataBuffer wrap = exchange.getResponse().bufferFactory().wrap(bytes);
            return exchange.getResponse().writeWith(Flux.just(wrap));
        });

        return http.build();
    }
}