package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(value = "Photo", description = "A DTO representing new Photo object")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NewPhotoDTO{
    @ApiModelProperty(
            position = 1,
            value = "Photo Name Text",
            name = "PhotoTitle",
            dataType = "java.lang.String",
            example = "img.jpg",
            required = true
    )
    private String photoName;

    @ApiModelProperty(
            position = 2,
            value = "User Email Text",
            name = "Email",
            dataType = "java.lang.String",
            example = "batteryAcid@gmail.com",
            required = true
    )
    private String userEmail;

    @ApiModelProperty(
            position = 3,
            value = "User Album",
            name = "AlbumName",
            dataType = "java.lang.String",
            example = "In the Dark",
            required = false
    )
    private String albumName;
}
