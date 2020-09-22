package com.vrapalis.www.chat.security.domain.common;

import com.vrapalis.www.libraries.utils.dao.UtilsServerErrorResponse;
import com.vrapalis.www.libraries.utils.error.UtilsBeanValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@ControllerAdvice
public class SecurityRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UtilsBeanValidationError.class})
    protected ResponseEntity<Object> handleConflict(UtilsBeanValidationError ex, WebRequest request) {
        final var errorResponse = new UtilsServerErrorResponse("Bean Validation Error", ex.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
