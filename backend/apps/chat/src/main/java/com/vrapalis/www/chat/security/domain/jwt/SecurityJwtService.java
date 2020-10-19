package com.vrapalis.www.chat.security.domain.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vrapalis.www.chat.security.domain.common.SecurityReadJwtTokenException;
import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;

public interface SecurityJwtService {
    String generateJwtToken(SecurityUserEntity user) throws JsonProcessingException;

    SecurityUserEntity readJwtToken(String jwtToken) throws SecurityReadJwtTokenException;
}
