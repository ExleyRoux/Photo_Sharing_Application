package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.ps.model.dto.*;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.model.mapper.*;
import xyz.ps.repository.PhotoRepository;
import xyz.ps.repository.UserRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.exception.PhotoNotFoundException;

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
    @Autowired
    private UploadNewPhotoService uploadNewPhotoService;

    public PhotoDTO createNewPhoto(NewPhotoDTO newPhotoDTO){
        try {
            System.out.println("Looking for Database Entries");
            PhotoModel i = new PhotoModel();

            UserModel user = getUserService.getUserModelByEmail(newPhotoDTO.getUserEmail());

            String albumTitle = newPhotoDTO.getAlbumName();

            AlbumModel albumModel;
            try {
                albumModel = getAlbumService.getAlbumByUserIdAndAlbumName(user.getUserId(), albumTitle);
            }
            catch (AlbumNotFoundException e){
                NewAlbumDTO newAlbumCreate = new NewAlbumDTO();
                newAlbumCreate.setTitle(newPhotoDTO.getAlbumName());
                newAlbumCreate.setUserId(user.getUserId());
                albumModel = createNewAlbumService.createNewAlbum(newAlbumCreate);
            }

            MultipartFile file = newPhotoDTO.getPhoto();
            if(file == null){
                throw new PhotoNotFoundException("Photo not attached");
            }

            i.setPhotoName(file.getOriginalFilename());
            i.setUser(user);
            i.setAlbum(albumModel);

            uploadNewPhotoService.UploadNewPhoto(file, (user.getUserId() + "-" + albumModel.getAlbumID()));
            System.out.println("Photo being saved to db");
            return new PhotoModelToDTOMapper().mapToModel(photoRepository.save(i));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
