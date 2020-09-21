package com.vrapalis.www.chat.security.mapper;

import com.vrapalis.www.chat.security.domain.user.mapper.SecurityUserMapper;
import com.vrapalis.www.chat.security.domain.user.mapper.SecurityUserMapperImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SecurityUserMapperImpl.class)
public abstract class SecurityAbstractMapperTest {
    @Autowired
    SecurityUserMapper userMapper;
}
