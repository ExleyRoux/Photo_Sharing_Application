package xyz.ps.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@ApiModel(value = "PhotoDTO", description = "A DTO representing Photo object - used in direction repo to controller")
@Setter
@Getter
@NoArgsConstructor
public class PhotoDTO {

    private String photoName;
    @JsonIgnore
    private UserDTO userDTO;
    @JsonIgnore
    private List<UserDTO> sharedUsersDTO;
    @JsonIgnore
    private AlbumDTO albumDTO;
    private URI photo;
    @JsonIgnore
    private Integer Id;
}
