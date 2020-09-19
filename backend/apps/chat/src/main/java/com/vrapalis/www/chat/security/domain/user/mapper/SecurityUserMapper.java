package com.vrapalis.www.chat.security.domain.user.mapper;

import com.vrapalis.www.chat.security.domain.user.entitiy.SecurityUserEntity;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SecurityUserMapper {
    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    SecurityUserDao entityToDao(SecurityUserEntity entity);
}
