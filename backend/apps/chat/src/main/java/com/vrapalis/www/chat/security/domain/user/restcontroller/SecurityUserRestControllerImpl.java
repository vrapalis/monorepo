package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.common.SecurityAuthenticationException;
import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import com.vrapalis.www.chat.security.domain.user.service.SecurityUserService;
import com.vrapalis.www.libraries.utils.assertion.UtilsAssertions;
import com.vrapalis.www.libraries.utils.dao.UtilsServerResponseDao;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class
SecurityUserRestControllerImpl implements SecurityUserRestController {
    private SecurityUserService userService;

    @Override
    public ResponseEntity<UtilsServerResponseDao> login(@Valid SecurityUserPrincipalDao principal, BindingResult result)
            throws SecurityAuthenticationException {
        UtilsAssertions.noBeanValidationErrors(result);
        return userService.login(principal);
    }
}
