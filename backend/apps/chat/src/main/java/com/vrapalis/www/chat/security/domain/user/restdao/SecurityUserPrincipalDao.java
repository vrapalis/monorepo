package com.vrapalis.www.chat.security.domain.user.restdao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class SecurityUserPrincipalDao {
    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 6, max = 15)
    private String password;
}
