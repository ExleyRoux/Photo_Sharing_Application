package xyz.ps.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

@ApiModel(value = "User", description = "A DTO representing User object")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    @ApiModelProperty(
            position = 1,
            value = "",
            name = "First Name",
            dataType = "String",
            example = "Jaco",
            allowEmptyValue = false,
            required = false
    )
    public String getFirstName(){
        return this.firstName;
    }


}
