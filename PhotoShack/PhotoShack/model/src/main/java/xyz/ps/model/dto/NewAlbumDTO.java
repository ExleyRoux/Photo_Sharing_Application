package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(value = "Album", description = "A DTO representing a new Album object")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NewAlbumDTO {

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
            position = 2,
            example = "123",
            required = true
    )
    private Integer userId;
}