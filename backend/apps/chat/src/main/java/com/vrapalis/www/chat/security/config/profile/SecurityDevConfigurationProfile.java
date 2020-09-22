package com.vrapalis.www.chat.security.config.profile;

import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import com.vrapalis.www.chat.security.domain.user.repository.SecurityUserRepository;
import com.vrapalis.www.swagger.SwaggerConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("dev")
@Import(SwaggerConfiguration.class)
@AllArgsConstructor
@ComponentScan(basePackages = {"com.vrapalis.www.swagger.*"})
public class SecurityDevConfigurationProfile {
    private SecurityUserRepository userRepository;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            final SecurityUserEntity userEntity = SecurityUserEntity.builder()
                    .email("admin@admin.com")
                    .password(new BCryptPasswordEncoder().encode("123456"))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();
            userRepository.save(userEntity);
        };
    }
}
