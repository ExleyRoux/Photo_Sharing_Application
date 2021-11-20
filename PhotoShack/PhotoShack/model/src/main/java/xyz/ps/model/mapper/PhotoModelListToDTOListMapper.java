package xyz.ps.model.mapper;

import xyz.ps.repository.model.PhotoModel;
import xyz.ps.model.dto.PhotoDTO;

import java.util.List;

public class PhotoModelListToDTOListMapper {

    public List<PhotoDTO> mapToModel(List<PhotoModel> photoModels){
        List<PhotoDTO> photoDTOS = null;
        for(PhotoModel i : photoModels){
            photoDTOS.add(new PhotoModelToDTOMapper().mapToModel(i));
        }
        return photoDTOS;
    }
}
