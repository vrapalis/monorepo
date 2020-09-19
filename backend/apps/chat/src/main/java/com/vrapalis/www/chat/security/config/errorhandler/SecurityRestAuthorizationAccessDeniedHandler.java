package com.vrapalis.www.chat.security.config.errorhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
@AllArgsConstructor
public class SecurityRestAuthorizationAccessDeniedHandler implements AccessDeniedHandler {
    private ObjectMapper mapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        OutputStream out = response.getOutputStream();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        mapper.writeValue(out, "UNAUTHORIZED");
        out.flush();
    }

}
