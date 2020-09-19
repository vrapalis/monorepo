package com.vrapalis.www.chat.security.config.errorhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
@AllArgsConstructor
public class SecurityRestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {
        OutputStream out = response.getOutputStream();
        response.setStatus(HttpStatus.FORBIDDEN.value());
        mapper.writeValue(out, "Provided credentials are not correct");
        out.flush();
    }
}

