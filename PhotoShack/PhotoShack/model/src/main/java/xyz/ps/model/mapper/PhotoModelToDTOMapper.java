package xyz.ps.model.mapper;

import xyz.ps.repository.model.PhotoModel;
import xyz.ps.model.dto.PhotoDTO;

public class PhotoModelToDTOMapper {

    public PhotoDTO mapToModel(PhotoModel photo){
        PhotoDTO i = new PhotoDTO();
        i.setPhotoName(photo.getPhotoName());
        i.setId(photo.getPhotoID());
        i.setUserDTO(new UserModelToDTOMapper().mapToModel(photo.getUser()));
        return i;
    }
}
