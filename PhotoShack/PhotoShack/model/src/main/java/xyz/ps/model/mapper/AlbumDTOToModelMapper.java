package xyz.ps.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.ps.model.AlbumModel;
import xyz.ps.model.dto.AlbumDTO;
import xyz.ps.model.dto.NewAlbumDTO;
import xyz.ps.repository.UserRepository;
import xyz.ps.service.GetUserService;

public class AlbumDTOToModelMapper {

    @Autowired
    public UserRepository userRepository;

    public AlbumModel mapToModel(AlbumDTO dto){
        AlbumModel i = new AlbumModel();
        i.setPhotoModelList(new PhotoDTOListToModelListMapper().mapToModel(dto.getPhotoDTOS()));
        i.setUser(new UserDTOToModelMapper().mapToModel(dto.getUserDTO()));
        i.setTitle(dto.getTitle());
        return i;
    }

    public AlbumModel mapToModel(NewAlbumDTO dto){
        AlbumModel i = new AlbumModel();
        i.setTitle(dto.getTitle());
        i.setUser(userRepository.);
        return i;
    }
}
