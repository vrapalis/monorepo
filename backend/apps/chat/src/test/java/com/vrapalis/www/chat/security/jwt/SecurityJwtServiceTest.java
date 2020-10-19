package com.vrapalis.www.chat.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vrapalis.www.chat.security.domain.common.SecurityReadJwtTokenException;
import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.vrapalis.www.chat.security.jwt.SecurityJwtServiceGivenData.givenUserEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("Jwt service test")
@ExtendWith(SpringExtension.class)
public class SecurityJwtServiceTest extends SecurityJwtServiceTestConfiguration {

    @BeforeEach
    void setUp() throws JsonProcessingException {
        userEntity = givenUserEntity();
        jwtToken = jwtService.generateJwtToken(userEntity);
    }

    @Test
    @DisplayName("Init test")
    void initTest() {
        assertThat(jwtService).isNotNull();
    }

    @Test
    @DisplayName("Create jwt token test")
    void createJwtToken() throws JsonProcessingException {
        assertThat(jwtToken).isNotEmpty();
    }

    @Test
    @DisplayName("Read jwt token")
    void readJwtToken() throws JsonProcessingException, SecurityReadJwtTokenException {
        // When
        SecurityUserEntity readUserFromJwtToken = jwtService.readJwtToken(jwtToken);

        // Then
        assertThat(readUserFromJwtToken.getEmail()).isEqualTo(userEntity.getEmail());
    }

    @Test
    @DisplayName("Test should throw exception if token is not valid")
    void shouldThrowExceptionIfJwtTokenIsNotValid() {
        assertThatThrownBy(() -> {
            // Given expired token
            jwtProperties.setExpireDate(-20000);
            final var generateJwtToken = jwtService.generateJwtToken(userEntity);

            // When read the token
            jwtService.readJwtToken(generateJwtToken);
        }).isInstanceOf(SecurityReadJwtTokenException.class); //Then trow exception
    }
}
