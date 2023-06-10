package com.group04.employment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@Data
@TableName("public.user")
public class User implements UserDetails {
    @Id
    @TableField("userid")
    private String userId;
    @TableField("useraccount")
    private String userAccount;
    @TableField("accountname")
    private String accountName;
    @TableField("userpwd")
    private String userPwd;
    @TableField("usertype")
    private Integer userType;
    @TableField(exist = false)
    private String authority;

    public String getAuthority() {
        String authority = "";
        if (getUserType() == null)
            return "";
        switch (getUserType()) {
            case 0:
                authority = "ROLE_ADMIN";
                break;
            case 1:
                authority = "ROLE_USER";
                break;
            case 2:
                authority = "ROLE_RECRUIT";
                break;
            default:
                break;
        }
        return authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new SimpleGrantedAuthority(getAuthority()));
        return collection;
    }

    @Override
    public String getPassword() {
        return this.userPwd;
    }

    @Override
    public String getUsername() {
        return this.userAccount;
    }

    /**
     * 账户是否未过期,过期无法验证
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
