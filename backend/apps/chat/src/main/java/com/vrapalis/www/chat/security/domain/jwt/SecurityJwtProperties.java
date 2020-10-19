package com.vrapalis.www.chat.security.domain.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@Validated
@ConfigurationProperties(prefix = "vrapalis.security.jwt")
@PropertySource("classpath:/config/jwt/token.properties")
public class SecurityJwtProperties {
    /**
     * Jwt secret
     */
    @NotBlank
    private String secret;

    /**
     * Jwt token expire date
     */
    @NotNull
    private int expireDate;

    /**
     * Jwt token prefix
     */
    @NotBlank
    private String tokenPrefix;

    /**
     * Jwt header
     */
    @NotBlank
    private String header;

    /**
     * User info claim email
     */
    @NotBlank
    private String claimEmail;

    /**
     * User info claim username
     */
    @NotBlank
    private String claimUsername;

    /**
     * User info claim name
     */
    @NotBlank
    private String claimInfo;

    /**
     * User roles claim name
     */
    @NotBlank
    private String claimRoles;

    /**
     * User roles claim principals
     */
    @NotBlank
    private String claimPrincipals;

    /**
     * User id claim
     */
    @NotBlank
    private String claimId;

}
