package xyz.ps.model.mapper;

import xyz.ps.repository.model.AlbumModel;
import xyz.ps.model.dto.AlbumDTO;

public class AlbumModelToDTOMapper {
    public AlbumDTO mapToModel(AlbumModel albumModel){
        AlbumDTO i = new AlbumDTO();
        i.setTitle(albumModel.getTitle());
        i.setUserDTO(new UserModelToDTOMapper().mapToModel(albumModel.getUser()));
//        i.setPhotoDTOS(new PhotoModelListToDTOListMapper().mapToModel(albumModel.getPhotoModelList()));
        return i;
    }
}
