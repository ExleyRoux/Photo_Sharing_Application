package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Integer Id;
    private String photoName;
    @JsonIgnore
    private UserDTO userDTO;
    @JsonIgnore
    private List<UserDTO> sharedUsersDTO;
    @JsonIgnore
    private AlbumDTO albumDTO;
}
