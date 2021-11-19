package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
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
    private String photoName;
    private String userEmail;
    private String albumName;
}
