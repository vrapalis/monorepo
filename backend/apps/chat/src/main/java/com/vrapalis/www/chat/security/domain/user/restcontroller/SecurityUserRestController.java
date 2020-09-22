package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import com.vrapalis.www.libraries.utils.dao.UtilsServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(SecurityUserApiUrl.USER_BASE_API_URL)
@Api(tags = "User", description = "User management endpoint")
public interface SecurityUserRestController {

    @PostMapping("/login")
    @ApiOperation("User login")
    ResponseEntity<UtilsServerResponse> login(@Valid @RequestBody SecurityUserPrincipalDao userPrincipalDao, BindingResult result);
}
