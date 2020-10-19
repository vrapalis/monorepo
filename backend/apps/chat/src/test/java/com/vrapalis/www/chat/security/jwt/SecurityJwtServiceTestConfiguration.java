package com.vrapalis.www.chat.security.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrapalis.www.chat.security.domain.jwt.SecurityJwtProperties;
import com.vrapalis.www.chat.security.domain.jwt.SecurityJwtService;
import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class SecurityJwtServiceTestConfiguration {
    @Autowired
    protected SecurityJwtService jwtService;
    @Autowired
    protected SecurityJwtProperties jwtProperties;
    @Autowired
    protected ObjectMapper objectMapper;

    protected SecurityUserEntity userEntity;
    protected String jwtToken;

    @TestConfiguration
    @EnableConfigurationProperties(SecurityJwtProperties.class)
    @ComponentScan(basePackageClasses = SecurityJwtService.class,
            excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                    value = SecurityJwtProperties.class))
    public static class TestConfig {
        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }

        @Bean
        public Algorithm algorithm() {
            return Algorithm.HMAC256("secret");
        }
    }
}
