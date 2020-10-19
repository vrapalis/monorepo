package com.vrapalis.www.chat.security.domain.common;

import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserAuthenticationExceptionResponseDao;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserBeanValidationExceptionResponseDao;
import com.vrapalis.www.libraries.utils.throwable.UtilsBeanValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SecurityRestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Bean validation exception handler.
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {UtilsBeanValidationException.class})
    protected ResponseEntity<Object> beanValidationExceptionHandler(UtilsBeanValidationException ex, WebRequest request) {
        final var errorResponse = new SecurityUserBeanValidationExceptionResponseDao(ex.getMessage());
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    /**
     * Authentication exception handler.
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = SecurityAuthenticationException.class)
    protected ResponseEntity<Object> authenticationExceptionHandler(SecurityAuthenticationException ex, WebRequest request) {
        final var errorResponse = new SecurityUserAuthenticationExceptionResponseDao();
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
