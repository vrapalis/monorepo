package com.vrapalis.www.chat.security.domain.user.service;

import com.vrapalis.www.chat.security.domain.user.model.SecurityUserPrincipal;
import com.vrapalis.www.chat.security.domain.user.repository.SecurityUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class SecurityUserServiceImpl implements SecurityUserService {
    private SecurityUserRepository uRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = uRepository.findByEmail(username).orElseThrow(EntityNotFoundException::new);
        return new SecurityUserPrincipal(user);
    }
}
