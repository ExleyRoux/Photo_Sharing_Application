package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@ApiModel(value = "NewPhotoDTO", description = "A DTO representing new Photo object")
@Setter
@Getter
@Accessors(chain = true)
public class NewPhotoDTO{
//    @ApiModelProperty(
//            position = 1,
//            value = "Photo Name Text",
//            name = "PhotoTitle",
//            dataType = "java.lang.String",
//            example = "img.jpg",
//            required = true
//    )
//    private String photoName;

    @ApiModelProperty(
            position = 1,
            value = "User Email Text",
            name = "Email",
            dataType = "java.lang.String",
            example = "batteryAcid@gmail.com",
            required = true
    )
    private String userEmail;

    @ApiModelProperty(
            position = 2,
            value = "User Album",
            name = "AlbumName",
            dataType = "java.lang.String",
            example = "In the Dark",
            required = false
    )
    private String albumName;
    public String getAlbumName(){
        if(this.albumName == null){
            this.albumName = "root";
        }
        return this.albumName;
    }

//    @ApiModelProperty(
//            position = 4,
//            value = "Photo",
//            name = "Photo",
//            dataType = "java.io.File",
//            required = true
//    )
    @JsonIgnore
    private MultipartFile photo;

    public NewPhotoDTO(){
        this.albumName = "root";
    }

    @Override
    public String toString() {
        return "NewPhotoDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
