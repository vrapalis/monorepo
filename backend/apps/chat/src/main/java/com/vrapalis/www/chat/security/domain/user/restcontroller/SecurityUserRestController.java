package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/users")
public interface SecurityUserRestController {

    @PostMapping("/login")
    void greeting(@Valid @RequestBody SecurityUserPrincipalDao userPrincipalDao, BindingResult result);
}
