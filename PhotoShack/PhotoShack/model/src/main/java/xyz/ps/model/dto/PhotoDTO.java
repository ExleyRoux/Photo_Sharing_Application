package xyz.ps.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel(value = "Photo", description = "A DTO representing Photo object - used in direction repo to controller")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class PhotoDTO {
    private String photoName;
    private UserDTO userDTO;
    private List<UserDTO> sharedUsersDTO;
    private AlbumDTO albumDTO;
}
