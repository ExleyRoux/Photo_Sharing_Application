package xyz.ps.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(value = "Login", description = "A DTO Representing UserLogin")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class LoginUserDTO {

    @ApiModelProperty(
            position = 1,
            value = "User Email",
            name = "LastName",
            dataType = "java.lang.String",
            example = "Tankian@gmail.com",
            required = true
    )
    private String email;

    @ApiModelProperty(
            position = 2,
            value = "User Password",
            name = "UserPassword",
            dataType = "java.lang.String",
            example = "password",
            required = true
    )
    private String password;
}
