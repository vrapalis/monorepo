package com.vrapalis.www.chat.security.domain.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrapalis.www.chat.security.domain.common.SecurityReadJwtTokenException;
import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@AllArgsConstructor
public class SecurityJwtServiceImpl implements SecurityJwtService {
    private SecurityJwtProperties jwtProperties;
    private ObjectMapper objectMapper;
    private Algorithm algorithm;

    @Override
    public String generateJwtToken(SecurityUserEntity user) throws JsonProcessingException {
        return JWT.create()
                .withSubject(objectMapper.writeValueAsString(user))
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpireDate()))
                .sign(algorithm);
    }

    @Override
    public SecurityUserEntity readJwtToken(String jwtToken) throws SecurityReadJwtTokenException {
        SecurityUserEntity securityUserEntity = null;
        try {
            final var verify = JWT.require(algorithm).build().verify(jwtToken);
            final var userSubjectAsString = verify.getSubject();
            securityUserEntity = objectMapper.readValue(userSubjectAsString, SecurityUserEntity.class);
        } catch (Exception ex) {
            throw new SecurityReadJwtTokenException(ex);
        }
        return securityUserEntity;
    }
}
