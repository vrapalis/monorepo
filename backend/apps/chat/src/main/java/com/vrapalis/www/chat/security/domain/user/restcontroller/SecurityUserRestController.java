package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.common.SecurityAuthenticationException;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserAuthenticationExceptionResponseDao;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserAuthenticationSuccessResponseDao;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserBeanValidationExceptionResponseDao;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import com.vrapalis.www.libraries.utils.dao.UtilsServerResponseDao;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(SecurityUserApiUrl.USER_BASE_API_URL)
@Api(tags = "User", description = "User management endpoint")
public interface SecurityUserRestController {

    @PostMapping(value = "/login", produces = "application/json")
    @ApiOperation("User login")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Authentication success",
                    response = SecurityUserAuthenticationSuccessResponseDao.class),
            @ApiResponse(code = 400, message = "Authentication exception",
                    response = SecurityUserAuthenticationExceptionResponseDao.class),
            @ApiResponse(code = 422, message = "Bean validation exception",
            response = SecurityUserBeanValidationExceptionResponseDao.class)
    })
    ResponseEntity<UtilsServerResponseDao> login(@Valid @RequestBody SecurityUserPrincipalDao userPrincipalDao,
                                                 BindingResult result) throws SecurityAuthenticationException;
}
