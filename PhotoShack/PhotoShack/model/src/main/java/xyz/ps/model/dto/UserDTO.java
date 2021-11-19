package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

@ApiModel(value = "User", description = "A DTO representing User object")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO{

    @ApiModelProperty(
            position = 1,
            value = "User First Name",
            name = "FirstName",
            dataType = "java.lang.String",
            example = "Serj",
            required = false
    )
    private String firstName;

    @ApiModelProperty(
            position = 2,
            value = "User Last Name",
            name = "LastName",
            dataType = "java.lang.String",
            example = "Tankian",
            required = false
    )
    private String lastName;

    @ApiModelProperty(
            position = 1,
            value = "User Email",
            name = "Email",
            dataType = "java.lang.String",
            example = "serjtank@gmail.com",
            required = false
    )
    private String email;
}
