package com.vrapalis.www.chat.security.domain.user.repository;

import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUserEntity, Integer> {
    Optional<SecurityUserEntity> findByEmail(String email);
}
