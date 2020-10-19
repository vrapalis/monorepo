package com.vrapalis.www.chat.security.domain.user.restdao;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public final class SecurityUserResponsesDao {
    public final static String AUTHENTICATION_SUCCESS_MSG = "Authentication success";
    public final static String GIVEN_PATH = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
    public static final String AUTHENTICATION_EXCEPTION_MSG = "Authentication exception";
    public static final String AUTHENTICATION_DETAIL_EXCEPTION_MSG = "Bad credentials";
    public static final String BEAN_VALIDATION_EXCEPTION_MSG = "Bean validation exception";
    public static final String BEAN_VALIDATION_EXCEPTION_DETAILS_MSG = "Details trace";

    private SecurityUserResponsesDao() {
        throw new IllegalAccessError();
    }
}
