package com.vrapalis.www.chat.security.domain.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vrapalis.www.chat.security.domain.common.SecurityAuthenticationException;
import com.vrapalis.www.chat.security.domain.jwt.SecurityJwtService;
import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import com.vrapalis.www.chat.security.domain.user.model.SecurityUserPrincipal;
import com.vrapalis.www.chat.security.domain.user.repository.SecurityUserRepository;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserAuthenticationSuccessResponseDao;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import com.vrapalis.www.libraries.utils.dao.UtilsServerResponseDao;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@AllArgsConstructor
public class SecurityUserServiceImpl implements SecurityUserService {
    private AuthenticationManager authenticationManager;
    private SecurityUserRepository uRepository;
    private SecurityJwtService jwtService;

    @Override
    public ResponseEntity<UtilsServerResponseDao> login(SecurityUserPrincipalDao principal) throws SecurityAuthenticationException {
        String jwt = "";
        try {
            final var authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(principal.getEmail(),
                            principal.getPassword(), new ArrayList<>()));
            final var authenticatedUser = (UserDetails) authenticate.getPrincipal();
            final var userEntity = uRepository.findByEmail(authenticatedUser.getUsername())
                    .orElseThrow(EntityNotFoundException::new);
            jwt = jwtService.generateJwtToken(userEntity);
        } catch (AuthenticationException | JsonProcessingException e) {
            throw new SecurityAuthenticationException(e);
        }
        return ResponseEntity.ok(new SecurityUserAuthenticationSuccessResponseDao(jwt));
    }
}
