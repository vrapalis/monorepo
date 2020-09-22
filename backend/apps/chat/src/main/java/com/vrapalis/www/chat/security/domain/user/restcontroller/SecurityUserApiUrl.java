package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.common.SecurityApiUrl;

public final class SecurityUserApiUrl extends SecurityApiUrl {
    public static final String USER_BASE_API_URL = APP_BASE_URL + "/users";

    private SecurityUserApiUrl() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}
