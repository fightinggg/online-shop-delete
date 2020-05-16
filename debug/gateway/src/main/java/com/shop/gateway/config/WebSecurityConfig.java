package com.shop.gateway.config;

import com.shop.gateway.dao.RoleUrlDao;
import com.shop.gateway.dao.UserDao;
import com.shop.gateway.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.function.Predicate;


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

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        http.csrf().disable();//必须支持跨域
        http.formLogin();
        http.logout().logoutUrl("/logout");

        // 定制url规则
        http.authorizeExchange().anyExchange().access((authentication, object) -> {
            HttpRequest httpRequest = object.getExchange().getRequest();
            String[] url = httpRequest.getURI().getPath().split("/");
            String preUrl = httpRequest.getMethodValue();
            if (url.length >= 2) preUrl += "/" + url[1];
            if (url.length >= 3) preUrl += "/" + url[2];
            List<String> strings = roleUrlDao.selectRoleByUrl(preUrl);
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

        return http.build();
    }

}