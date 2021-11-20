package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel(value = "DeletePhotoDTO", description = "A DTO received by controller to delete specific photo")
@Setter
@Getter
@Accessors(chain = true)
public class DeletePhotoDTO {

    @ApiModelProperty(
            position = 1,
            value = "Photo Title Text",
            name = "Photo Title",
            dataType = "java.lang.String",
            example = "img.jpg",
            required = true
    )
    private String photoName;

    @ApiModelProperty(
            position = 2,
            value = "Album Title Text",
            name = "Album Title",
            dataType = "java.lang.String",
            example = "root",
            required = false
    )
    private String albumName;
    public String getAlbumName(){
        if(this.albumName == null){
            this.albumName = "root";
        }
        return this.albumName;
    }

    @ApiModelProperty(
            position = 3,
            value = "User Email Text",
            name = "User Email",
            dataType = "java.lang.String",
            example = "email@email.com",
            required = true
    )
    private String userEmail;

    public DeletePhotoDTO(){
        this.albumName = "root";
    }
}
