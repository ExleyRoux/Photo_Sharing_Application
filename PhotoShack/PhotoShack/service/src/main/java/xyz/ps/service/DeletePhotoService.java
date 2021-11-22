package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.DeletePhotoDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.model.exception.ResourceNotFoundException;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.service.exception.UserNotFoundException;
import xyz.ps.model.mapper.PhotoModelToDTOMapper;
import xyz.ps.repository.PhotoRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.exception.PhotoNotFoundException;

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
    @Autowired
    private PhysicalPhotoService physicalPhotoService;

    public PhotoDTO deletePhoto(DeletePhotoDTO delPhotoDTO) {
        try {
            UserModel user = userService.getUserModelByEmail(delPhotoDTO.getUserEmail());
            AlbumModel albumModel = getAlbumService.getAlbumByUserIdAndAlbumName(user.getUserId(), delPhotoDTO.getAlbumName());
            PhotoModel photoModel = getPhotoService.getPhotoDModelByUserIdAndAlbumIdAndPhotoName(user.getUserId(), albumModel.getAlbumID(), delPhotoDTO.getPhotoName());

            photoRepository.deleteById(photoModel.getPhotoID());

            return new PhotoModelToDTOMapper().mapToModel(photoModel);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (AlbumNotFoundException e){
            throw new AlbumNotFoundException();
        }
        catch (PhotoNotFoundException e){
            throw new PhotoNotFoundException();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    public boolean deletePhotoById(Integer photoId){
        try {
            photoRepository.deleteById(photoId);
            PhotoModel i = getPhotoService.getPhotoModelById(photoId);

            physicalPhotoService.deletePhoto(i.getAlbum().getTitle(), i.getPhotoName());
            return true;
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
