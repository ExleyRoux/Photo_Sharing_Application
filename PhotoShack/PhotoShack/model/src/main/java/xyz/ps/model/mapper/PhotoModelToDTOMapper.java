package xyz.ps.model.mapper;

import xyz.ps.model.PhotoModel;
import xyz.ps.model.dto.PhotoDTO;

public class PhotoModelToDTOMapper {

    public PhotoDTO mapToModel(PhotoModel photo){
        PhotoDTO i = new PhotoDTO();
        i.setPhotoName(photo.getPhotoName());
        return i;
    }
}
