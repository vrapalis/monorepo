package com.vrapalis.www.chat.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SecurityMainConfiguration {
    @Bean
    public AuditorAware<String> auditorProvider() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return () -> Optional.ofNullable(authentication != null ? ((UserDetails) authentication.getPrincipal()).getUsername()
                : "unknown");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Jackson hibernate aware of lazy loading module.
     *
     * @return message converter.
     */
    @Bean
    public HttpMessageConverter<Object> jacksonHibernateLazyAwareMessageConverter() {
        final var mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        final var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Hibernate5Module());
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }

}
