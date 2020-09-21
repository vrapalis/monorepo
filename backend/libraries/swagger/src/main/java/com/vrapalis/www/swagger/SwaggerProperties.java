package com.vrapalis.www.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
@ConfigurationProperties(prefix = "swagger-api-documentation")
public class SwaggerProperties {
    /**
     * Contact name
     */
    @NotNull
    private String contactName;

    /**
     * Contact url
     */
    @NotNull
    private String contactUrl;

    /**
     * Contact email
     */
    @NotNull
    private String contactEmail;

    /**
     * Api title
     */
    @NotNull
    private String apiTitle;

    /**
     * Api description
     */
    @NotNull
    private String apiDescription;

    /**
     * Api version
     */
    @NotNull
    private String apiVersion;

    /**
     * Apis base packages
     */
    @NotNull
    private String apiBasePackages;
}
