package com.vrapalis.www.chat.security.domain.user.restdao;

import com.vrapalis.www.libraries.utils.dao.UtilsServerExceptionResponseDao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityUserBeanValidationExceptionResponseDao extends UtilsServerExceptionResponseDao {
    @ApiModelProperty(example = SecurityUserResponsesDao.BEAN_VALIDATION_EXCEPTION_MSG, position = 1)
    private String msg = SecurityUserResponsesDao.BEAN_VALIDATION_EXCEPTION_MSG;

    @ApiModelProperty(example = SecurityUserResponsesDao.BEAN_VALIDATION_EXCEPTION_DETAILS_MSG, position = 2)
    private String errorMsg;

    @ApiModelProperty(example = "Given path", position = 3)
    private String path = SecurityUserResponsesDao.GIVEN_PATH;

    public SecurityUserBeanValidationExceptionResponseDao(String errorMsg) {
        super("", errorMsg, "");
        setMsg(msg);
        setErrorMsg(errorMsg);
        setPath(path);
    }
}
