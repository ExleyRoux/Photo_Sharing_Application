package xyz.ps.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.UserRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.model.dto.AlbumDTO;
import xyz.ps.model.dto.NewAlbumDTO;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;

import java.util.List;

public class AlbumDTOToModelMapper {

    @Autowired
    private UserRepository userRepository;

    public AlbumModel mapToModel(AlbumDTO dto){
        AlbumModel i = new AlbumModel();
//        i.setPhotoModelList(new PhotoDTOListToModelListMapper().mapToModel(dto.getPhotoDTOS()));
        i.setUser(new UserDTOToModelMapper().mapToModel(dto.getUserDTO()));
        i.setTitle(dto.getTitle());
        return i;
    }

//    public AlbumModel mapToModel(NewAlbumDTO dto){
//        AlbumModel j = new AlbumModel();
//        UserModel i = userRepository.findByEmailLikeIgnoreCase(dto.getUserId());
//
//        if (i == null){
//            throw new RuntimeException("User does not exist");
//        }
//        else {
//            j.setUser(i);
//            j.setTitle(dto.getTitle());
////            j.setPhotoModelList(null);
//            return j;
//        }
//    }
}
