package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import xyz.ps.model.UserModel;

@ApiModel(value = "Album", description = "A DTO representing a new Album object")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NewAlbumDTO {
    private String title;
    private String userEmail;
}