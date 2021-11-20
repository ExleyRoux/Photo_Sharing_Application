package xyz.ps.model.mapper;

import xyz.ps.repository.model.PhotoModel;
import xyz.ps.model.dto.PhotoDTO;

import java.util.List;

public class PhotoDTOListToModelListMapper {
    public List<PhotoModel> mapToModel(List<PhotoDTO> dtoList){
        List<PhotoModel> photoModels = null;
        for (PhotoDTO i : dtoList){
            photoModels.add(new PhotoDTOToModelMapper().mapToModel(i));
        }
        return photoModels;
    }
}
