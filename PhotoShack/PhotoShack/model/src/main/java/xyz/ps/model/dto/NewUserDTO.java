package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(value = "User", description = "A DTO representing User object")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NewUserDTO extends UserDTO{

    @ApiModelProperty(
            value = "User Password",
            name = "UserPassword",
            dataType = "java.lang.String",
            example = "password",
            required = true
    )
    private String password;
}