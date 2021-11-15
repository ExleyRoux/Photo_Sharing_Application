package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(value = "User", description = "A DTO representing User object")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NewUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}