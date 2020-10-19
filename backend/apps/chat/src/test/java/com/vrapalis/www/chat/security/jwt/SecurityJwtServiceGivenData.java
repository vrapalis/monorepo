package com.vrapalis.www.chat.security.jwt;

import com.vrapalis.www.chat.security.domain.authority.SecurityAuthorityEntity;
import com.vrapalis.www.chat.security.domain.role.SecurityRoleEntity;
import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;

import java.util.Arrays;
import java.util.HashSet;

public final class SecurityJwtServiceGivenData {
    private SecurityJwtServiceGivenData() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static SecurityUserEntity givenUserEntity() {
        return SecurityUserEntity.builder()
                .password("123456")
                .email("email@email.com")
                .roles(new HashSet<>(Arrays.asList(
                        SecurityRoleEntity.builder()
                                .name("role_admin")
                                .authorities(new HashSet<>(Arrays.asList(
                                        SecurityAuthorityEntity.builder().name("read_user").build(),
                                        SecurityAuthorityEntity.builder().name("lock_user").build(),
                                        SecurityAuthorityEntity.builder().name("write_user").build()
                                )))
                                .build(),
                        SecurityRoleEntity.builder().name("role_user").build()
                )))
                .build();
    }
}
