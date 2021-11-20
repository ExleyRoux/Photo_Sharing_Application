package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.*;
import xyz.ps.service.exception.EmailNotFoundException;
import xyz.ps.model.mapper.*;
import xyz.ps.repository.PhotoRepository;
import xyz.ps.repository.UserRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;

@Service
public class CreateNewPhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GetUserService getUserService;
    @Autowired
    private GetAlbumService getAlbumService;
    @Autowired
    private CreateNewAlbumService createNewAlbumService;

    public PhotoDTO createNewPhoto(NewPhotoDTO newPhotoDTO){
        try {
            PhotoModel i = new PhotoModel();

            UserModel user = getUserService.getUserModelByEmail(newPhotoDTO.getUserEmail());
            if (user == null){
                throw new EmailNotFoundException();
            }

            String albumTitle = newPhotoDTO.getAlbumName();
            if (albumTitle == "" || albumTitle == null){
                albumTitle = "root";
            }

            AlbumModel albumModel = getAlbumService.getAlbumByUserAndAlbumName(user, albumTitle);
            if(albumModel == null){
                NewAlbumDTO newAlbumCreate = new NewAlbumDTO();
                newAlbumCreate.setTitle(newPhotoDTO.getAlbumName());
                newAlbumCreate.setUserEmail(user.getEmail());
                albumModel = createNewAlbumService.createNewAlbum(newAlbumCreate);
            }

            i.setPhotoName(newPhotoDTO.getPhotoName());
            i.setUser(user);
            i.setAlbum(albumModel);

            return new PhotoModelToDTOMapper().mapToModel(photoRepository.save(i));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
