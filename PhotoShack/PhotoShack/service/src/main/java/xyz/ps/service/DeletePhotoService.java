package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.DeletePhotoDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.service.exception.EmailNotFoundException;
import xyz.ps.model.mapper.PhotoModelToDTOMapper;
import xyz.ps.repository.PhotoRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.exception.PhotoNotFoundException;
import xyz.ps.service.exception.UpdateDatabaseException;

@Service
public class DeletePhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private GetUserService userService;
    @Autowired
    private GetAlbumService getAlbumService;
    @Autowired
    private GetPhotoService getPhotoService;

    public PhotoDTO deletePhoto(DeletePhotoDTO delPhotoDTO) {
        try {
            UserModel user = userService.getUserModelByEmail(delPhotoDTO.getUserEmail());
            if (user == null){
                throw new EmailNotFoundException();
            }

            AlbumModel albumModel = getAlbumService.getAlbumByUserAndAlbumName(user, delPhotoDTO.getAlbumName());
            if (albumModel == null){
                throw new AlbumNotFoundException();
            }

            PhotoModel photoModel = getPhotoService.getPhotoByUserAndAlbumAndPhotoName(user, albumModel, delPhotoDTO.getPhotoName());
            if (photoModel == null){
                throw new PhotoNotFoundException();
            }

            photoRepository.deleteById(photoModel.getPhotoID());

            return new PhotoModelToDTOMapper().mapToModel(photoModel);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
