package xyz.ps.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.ps.model.exception.EmailNotFoundException;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.UserRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.PhotoDTO;

public class PhotoDTOToModelMapper {

    @Autowired
    public AlbumRepository albumRepository;
    @Autowired
    public UserRepository userRepository;

    public PhotoModel mapToModel(PhotoDTO dto){
        PhotoModel mod = new PhotoModel();
        mod.setPhotoName(dto.getPhotoName());
//        mod.setAlbum(new AlbumDTOToModelMapper().mapToModel(dto.getAlbumDTO()));
        mod.setUser(new UserDTOToModelMapper().mapToModel(dto.getUserDTO()));
        return mod;
    }

    public PhotoModel mapToModel(NewPhotoDTO dto){
        PhotoModel mod = new PhotoModel();
//        AlbumModel i = albumRepository.getAlbum(userRepository.getUser(dto.getUserEmail()), dto.getAlbumName());
        mod.setPhotoName(dto.getPhotoName());
//        mod.setUser(userRepository.findByEmailLikeIgnoreCase(dto.getUserEmail()));
        if (mod.getUser() == null)
            throw new EmailNotFoundException();
//        mod.setAlbum(i);
        return mod;
    }
}
