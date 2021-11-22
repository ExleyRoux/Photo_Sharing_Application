package xyz.ps.model.mapper;

import org.springframework.web.multipart.MultipartFile;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.model.dto.PhotoDTO;

import java.net.URI;
import java.util.Optional;

public class PhotoModelToDTOMapper {

    public PhotoDTO mapToModel(PhotoModel photo){
        PhotoDTO i = new PhotoDTO();
        i.setPhotoName(photo.getPhotoName());
        i.setId(photo.getPhotoID());
        i.setUserDTO(new UserModelToDTOMapper().mapToModel(photo.getUser()));
        return i;
    }

    public PhotoDTO mapToModel(PhotoModel k, URI file) {
        PhotoDTO i = mapToModel(k);
        i.setPhoto(file);
        return i;
    }
}
