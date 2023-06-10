package com.group04.employment.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */
@Component
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    // security重定向策略
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    /*
     * 重写handel方法，通过RedirectStrategy重定向到指定url
     *
     * */

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 根据当前认证用户的角色返回适当的URL
        String targetURL = getTargetURL(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("user", authentication.getPrincipal());
        //重定向到指定URL
        redirectStrategy.sendRedirect(request, response, targetURL);
    }

    /*
     * 从Authentication对象中提取当前登录用户的角色，根据其角色返回适当的URL
     * */
    private String getTargetURL(Authentication authentication) {
        String url = "";
        //获取当前登录用户的权限集合
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority au : authorities) {
            roles.add(au.getAuthority());
        }
        //判断不同角色的用户跳转到不同的URL
        //这里的url是控制器的请求匹配路径
        if (roles.contains("ROLE_USER")) {
            url = "/employment/employmentinfo";
        } else if (roles.contains("ROLE_RECRUIT")) {
            url = "/recruit/index";
        } else if (roles.contains("ROLE_ADMIN")) {
            url = "/employment/employmentinfo";
        } else {
            url = "/employment";
        }
        return url;
    }
}
