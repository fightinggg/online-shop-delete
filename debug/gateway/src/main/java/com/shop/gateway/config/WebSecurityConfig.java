package com.shop.gateway.config;

import com.shop.gateway.dao.RoleUrlDao;
import com.shop.gateway.dao.UserDao;
import com.shop.gateway.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.*;
import java.util.regex.Pattern;


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
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(str.getBytes());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }


    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        http.csrf().disable();//必须支持跨域
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
            List<String> strings = roleUrlDao.selectRoleByUrl(preUrl.toString());
            System.out.println(httpRequest.getURI() + "    " + preUrl + "    " + strings);

            if (strings.isEmpty()) return Mono.just(new AuthorizationDecision(false));
            else if (strings.contains("ROLE_TOURIST")) return Mono.just(new AuthorizationDecision(true));
            else return authentication
                        .flatMapIterable(Authentication::getAuthorities)
                        .map(GrantedAuthority::getAuthority)
                        .any(strings::contains)
                        .map(AuthorizationDecision::new)
                        .defaultIfEmpty(new AuthorizationDecision(false));
        });

        // 添加过滤器，
        http.addFilterAt((exchange, chain) -> {
            ServerHttpRequest mutatedRequest = exchange.getRequest().mutate().header("id", "1").build();
            ServerWebExchange mutatedExchange = exchange.mutate().request(mutatedRequest).build();
            return chain.filter(mutatedExchange);
        }, SecurityWebFiltersOrder.HTTP_HEADERS_WRITER);

        return http.build();
    }
}