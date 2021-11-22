package xyz.ps.model.mapper;

import xyz.ps.repository.model.PhotoModel;
import xyz.ps.model.dto.PhotoDTO;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhotoModelListToDTOListMapper {

    public List<PhotoDTO> mapToModel(List<PhotoModel> photoModels){
        List<PhotoDTO> photoDTOS = new ArrayList<>();
        for(PhotoModel i : photoModels){
            photoDTOS.add(new PhotoModelToDTOMapper().mapToModel(i));
        }
        return photoDTOS;
    }

//    public List<PhotoDTO> mapToModel(Map<List<PhotoModel>, List<URI>> photomodelAndUriMap){
//        List<PhotoDTO> photoDTOS = new ArrayList<>();
//
//        photomodelAndUriMap.forEach((photoModels, uris) ->
//                photoDTOS.add(new PhotoModelToDTOMapper().mapToModel(photoModels.get(), uris.get())));
//
//        for(PhotoModel i : photomodelAndUriMap){
//            photoDTOS.add(new PhotoModelToDTOMapper().mapToModel(i));
//        }
//        return photoDTOS;
//    }
}
