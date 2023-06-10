package com.group04.employment.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group04.employment.entity.User;
import com.group04.employment.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/5 20:24
 */
@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("useraccount", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("通过验证");
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        String roles = "ROLE_" + u.getAuthority();
//
//        //将当前用户的权限保存为用户的认证权限
//        new SimpleGrantedAuthority(roles);
//        org.springframework.security.core.userdetails.User su = new org.springframework.security.core.userdetails.User(u.getUserAccount(), u.getUserPwd(), authorities);

        return user;
    }
}
