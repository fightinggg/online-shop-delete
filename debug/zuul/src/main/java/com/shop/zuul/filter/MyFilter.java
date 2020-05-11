package com.shop.zuul.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.util.Arrays;

@Component
public class MyFilter extends ZuulFilter {

    public boolean shouldFilter() {   //判断过滤器是否生效
        // TODO Auto-generated method stub
        return true;
    }

    public Object run() throws ZuulException {  //编写顾虑器拦截业务逻辑代码
        // 案例：拦截所有都服务接口，判断服务接口上是否有传递userToekn参数
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //验证token时候 token的参数 从请求头获取
        String[] requestPath = request.getRequestURI().split("/");
        String userType = requestPath[2];
        String userId = requestPath[3];
        // 不拦截任意访问

        if (userType.equals("everyone") || userType.equals("MicroServiceInner")) return null;
        else {
            HttpSession session = request.getSession();
//            System.out.println(session.getId());
            if (userId.equals(session.getAttribute(userType))) {
                // 不拦截身份认证成功的访问
            } else {
                currentContext.setSendZuulResponse(false);  //false  不会继续往下执行 不会调用服务接口了 网关直接响应给客户了
                currentContext.setResponseBody("you have not login,please loginIn");
                currentContext.setResponseStatusCode(401);
            }
            return null;
        }
    }

    @Override
    public String filterType() {     //过滤器的类型
        // TODO Auto-generated method stub
        return "pre";   //表示在请求之前执行
    }

    @Override
    public int filterOrder() {  //过滤器执行的顺序 一个请求在同一个阶段存在多个过滤器时候，多个过滤器执行顺序问题
        // TODO Auto-generated method stub
        return 0;
    }
}