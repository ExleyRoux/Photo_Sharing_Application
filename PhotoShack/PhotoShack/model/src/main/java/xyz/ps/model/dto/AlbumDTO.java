package xyz.ps.model.dto;

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
    @ApiModelProperty(
            position = 1,
            value = "Album Title Text",
            name = "AlbumTitle",
            dataType = "java.lang.String",
            example = "Mesmerize",
            required = true
    )
    private String title;

    @ApiModelProperty(
            required = true,
            position = 2
    )
    private UserDTO userDTO;

    @ApiModelProperty(
            position = 3,
            required = false
    )
    private List<PhotoDTO> photoDTOS;
}
