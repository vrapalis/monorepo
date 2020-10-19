package com.vrapalis.www.chat.security.domain.user.service;

import com.vrapalis.www.chat.security.domain.common.SecurityAuthenticationException;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import com.vrapalis.www.libraries.utils.dao.UtilsServerResponseDao;
import org.springframework.http.ResponseEntity;

public interface SecurityUserService {
    ResponseEntity<UtilsServerResponseDao> login(SecurityUserPrincipalDao principal) throws SecurityAuthenticationException;
}
