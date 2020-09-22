package com.vrapalis.www.chat.security.domain.user.restdao;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "admin@admin.com")
    private String email;

    @NotNull
    @Size(min = 6, max = 15)
    @ApiModelProperty(example = "123456")
    private String password;
}
