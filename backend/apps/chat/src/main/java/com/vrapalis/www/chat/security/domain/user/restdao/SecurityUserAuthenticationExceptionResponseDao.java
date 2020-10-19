package com.vrapalis.www.chat.security.domain.user.restdao;

import com.vrapalis.www.libraries.utils.dao.UtilsServerExceptionResponseDao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityUserAuthenticationExceptionResponseDao extends UtilsServerExceptionResponseDao {
    @ApiModelProperty(example = SecurityUserResponsesDao.AUTHENTICATION_EXCEPTION_MSG, position = 1)
    private String msg = SecurityUserResponsesDao.AUTHENTICATION_EXCEPTION_MSG;

    @ApiModelProperty(example = SecurityUserResponsesDao.AUTHENTICATION_DETAIL_EXCEPTION_MSG, position = 2)
    private String errorMsg = SecurityUserResponsesDao.AUTHENTICATION_DETAIL_EXCEPTION_MSG;

    @ApiModelProperty(example = "Given path", position = 3)
    private String path = SecurityUserResponsesDao.GIVEN_PATH;

    public SecurityUserAuthenticationExceptionResponseDao() {
        super("", "", "");
        setMsg(msg);
        setPath(path);
        setErrorMsg(errorMsg);
    }
}
