package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
