package com.vrapalis.www.chat.security.mapper;

import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("User mapper test")
public class SecurityUserMapperTest extends SecurityAbstractMapperTest {

    @Test
    @DisplayName("Entity to dao test")
    void entityToDaoTest() {
        // Given
        final var entity = SecurityUserEntity.builder().id(1).build();

        // When
        final var dao = userMapper.entityToDao(entity);

        // Then
        assertThat(entity.getId()).isEqualTo(dao.getUserId());
    }
}
