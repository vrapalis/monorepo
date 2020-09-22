package com.vrapalis.www.chat.security.domain.user.restcontroller;

import com.vrapalis.www.chat.security.domain.user.restdao.SecurityUserPrincipalDao;
import com.vrapalis.www.libraries.utils.assertion.UtilsAssertions;
import com.vrapalis.www.libraries.utils.dao.UtilsServerErrorResponse;
import com.vrapalis.www.libraries.utils.dao.UtilsServerResponse;
import com.vrapalis.www.libraries.utils.dao.UtilsServerSuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class SecurityUserRestControllerImpl implements SecurityUserRestController {
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<UtilsServerResponse> login(@Valid SecurityUserPrincipalDao principal, BindingResult result) {
        UtilsAssertions.noBeanValidationErrors(result);
        try {
            final var authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(principal.getEmail(),
                    principal.getPassword(), new ArrayList<>()));
            System.out.println("User is authenticated: " + authenticate.isAuthenticated());
        } catch (AuthenticationException ex) {
            System.out.println(ex);
            return ResponseEntity.badRequest().body(new UtilsServerErrorResponse("", "", ""));
        }
        return ResponseEntity.ok(new UtilsServerSuccessResponse("", ""));
    }
}
