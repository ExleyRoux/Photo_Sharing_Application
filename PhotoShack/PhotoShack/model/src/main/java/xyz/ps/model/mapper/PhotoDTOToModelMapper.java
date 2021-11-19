package xyz.ps.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.AlbumModel;
import xyz.ps.model.PhotoModel;
import xyz.ps.model.UserModel;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.service.GetAlbumService;
import xyz.ps.service.GetUserExistsService;
import xyz.ps.service.GetUserService;

public class PhotoDTOToModelMapper {

    @Autowired
    public GetAlbumService albumService;
    public GetUserService getUserService;

    public PhotoModel mapToModel(PhotoDTO dto){
        PhotoModel mod = new PhotoModel();
        mod.setPhotoName(dto.getPhotoName());
        mod.setAlbum(new AlbumDTOToModelMapper().mapToModel(dto.getAlbumDTO()));
        mod.setUser(new UserDTOToModelMapper().mapToModel(dto.getUserDTO()));
        return mod;
    }

    public PhotoModel mapToModel(NewPhotoDTO dto){
        PhotoModel mod = new PhotoModel();
        AlbumModel i = albumService.getAlbum(getUserService.getUser(dto.getUserEmail()), dto.getAlbumName());

        mod.setPhotoName(dto.getPhotoName());
        mod.setUser(i.getUser());
        mod.setAlbum(i);
        return mod;
    }
}
