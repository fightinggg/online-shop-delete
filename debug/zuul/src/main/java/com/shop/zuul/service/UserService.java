package com.shop.zuul.service;

import com.shop.zuul.dao.RoleUrlDao;
import com.shop.zuul.dao.UserDao;
import com.shop.zuul.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    RoleUrlDao roleUrlDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        int id = 0;
        try {
            id = Integer.parseInt(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("用户名格式错误");
        }
        com.shop.zuul.entity.User user = userDao.selectByPrimaryKey(id);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : userRoleDao.selectRoleByUserId(id)) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return new User(username, user.getPassword(), authorities);
    }

    // 权限控制 = 访问对象id控制+访问URI控制
    public boolean check(Authentication authentication, HttpServletRequest request) {
        String[] URI = request.getRequestURI().split("/", 2);
        String pre = request.getMethod() + URI[0] + URI[1];
        List<String> need = roleUrlDao.selectRoleByUrl(pre);
        need.retainAll(authentication.getAuthorities());
        return false;
    }
}


