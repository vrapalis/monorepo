package com.vrapalis.www.chat.security.domain.user.restdao;

import com.vrapalis.www.libraries.utils.dao.UtilsServerSuccessResponseDao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityUserAuthenticationSuccessResponseDao extends UtilsServerSuccessResponseDao {
    @ApiModelProperty(example = SecurityUserResponsesDao.AUTHENTICATION_SUCCESS_MSG)
    private String msg = SecurityUserResponsesDao.AUTHENTICATION_SUCCESS_MSG;

    private String jwt;

    @ApiModelProperty(example = "Given path")
    private String path = SecurityUserResponsesDao.GIVEN_PATH;

    public SecurityUserAuthenticationSuccessResponseDao(String jwt) {
        super("", "");
        setMsg(msg);
        setJwt(jwt);
        setPath(path);
    }
}
