package com.cybertek.entity.common;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserProncipaal implements UserDetails {
    private User user;

    public UserProncipaal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority>authorities=new ArrayList<>();

    GrantedAuthority authority=new SimpleGrantedAuthority(this.user.getRole().getDescription());
    authorities.add(authority);
    //Many t many
//        this.user.getRoles().forEach(role->{GrantedAuthority authority=new SimpleGrantedAuthority(this.user.getRole().getDescription());
//        authorities.add(authority);
//        })
    return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassWord();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
