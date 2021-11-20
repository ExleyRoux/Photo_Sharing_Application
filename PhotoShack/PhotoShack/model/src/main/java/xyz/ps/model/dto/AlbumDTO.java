package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel(value = "Album", description = "A DTO representing Album object - object working in the direction from controller to repo")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class AlbumDTO {

    @JsonIgnore
    private Integer id;
    private String title;
    private UserDTO userDTO;
    private List<PhotoDTO> photoDTOS;
    private List<UserDTO> sharedUserDTOS;
}
