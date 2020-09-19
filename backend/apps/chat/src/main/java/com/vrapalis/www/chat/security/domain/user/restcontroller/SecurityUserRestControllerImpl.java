package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SecurityUserRestControllerImpl implements SecurityUserRestController {
    @Override
    public void greeting(@Valid SecurityUserPrincipalDao userPrincipalDao, BindingResult result) {
        System.out.println(userPrincipalDao);
        System.out.println(result);
    }
}
