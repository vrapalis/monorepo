package com.vrapalis.www.chat.security.domain.user.model;

import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SecurityUserPrincipal implements UserDetails {
    private final SecurityUserEntity uEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        uEntity.getRoles().forEach(role -> {
            final var grantedAuthorityFromRole = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthorityFromRole);
            role.getAuthorities().forEach(auth -> {
                final var grantedAuthority = new SimpleGrantedAuthority(auth.getName());
                authorities.add(grantedAuthority);
            });
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return uEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return uEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return uEntity.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return uEntity.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return uEntity.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return uEntity.isEnabled();
    }
}
