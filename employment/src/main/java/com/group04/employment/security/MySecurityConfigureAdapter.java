package com.group04.employment.security;

import com.group04.employment.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */
@Configuration
public class MySecurityConfigureAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserSecurityService userSecurityService;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        System.out.println("enter authenticationProvider");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //不隐藏用户未找到的异常
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(userSecurityService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        System.out.println("enter configure");
        http                // 禁用CSRF保护机制 关闭后才能正常发送post请求
                .csrf().disable().authorizeRequests().antMatchers("/", "static/**", "/resources/**", "/employment").permitAll()
//                .antMatchers("/employment/**","/recruit/**").hasRole("ADMIN")
                .antMatchers("/employment/**").hasAnyRole("USER", "ADMIN").antMatchers("/recruit/**").hasAnyRole("RECRUIT", "ADMIN")
                //其他所有请求登录后才能访问
                .anyRequest().authenticated().and().formLogin()
//                .loginProcessingUrl("/employment/login")
                .loginPage("/employment").successHandler(userAuthenticationSuccessHandler).usernameParameter("userAccount").passwordParameter("userPwd")
//                .failureUrl("/employment?error")
                .and().logout().permitAll().and()
                //访问没有权限地址
                .exceptionHandling().accessDeniedPage("/403");


    }
}
