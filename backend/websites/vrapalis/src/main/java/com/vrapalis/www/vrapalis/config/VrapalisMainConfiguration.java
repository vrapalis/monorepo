package com.vrapalis.www.vrapalis.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.vrapalis.www.libraries.websites"})
@EntityScan(basePackages = {"com.vrapalis.www.libraries.websites"})
@EnableJpaRepositories(basePackages = {"com.vrapalis.www.libraries.websites"})
public class VrapalisMainConfiguration {
}
