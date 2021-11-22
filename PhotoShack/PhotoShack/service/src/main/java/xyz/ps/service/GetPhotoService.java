package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.model.mapper.PhotoModelListToDTOListMapper;
import xyz.ps.model.mapper.PhotoModelToDTOMapper;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.PhotoRepository;
import xyz.ps.repository.UserRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.service.exception.UserNotFoundException;
import xyz.ps.service.exception.PhotoNotFoundException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetPhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    DownloadPhotoService downloadPhotoService;

//    public PhotoModel getPhotoModelByUserAndAlbumAndPhotoName(UserModel user, AlbumModel album, String photoName){
//        try {
//            return photoRepository.findByUserAndAlbumAndPhotoNameLike(user, album, photoName);
//        }
//        catch (Exception e){
//            throw new RuntimeException();
//        }
//    }

    public PhotoDTO getPhotoDTOByUserAndAlbumAndPhotoID(Integer userId, Integer albumId, Integer photoId){
        try {
            Optional<UserModel> i = userRepository.findById(userId);
            if (!i.isPresent())
                throw new UserNotFoundException();

            Optional<AlbumModel> j = albumRepository.findById(albumId);
            if(!j.isPresent())
                throw new AlbumNotFoundException();

            Optional<PhotoModel> k = photoRepository.findById(photoId);
            if(!k.isPresent())
                throw new PhotoNotFoundException();

            URI file = downloadPhotoService.downloadFile(i.get().getUserId() + "-" + j.get().getAlbumID(), k.get().getPhotoName());
            if (file == null)
                throw new PhotoNotFoundException();

            return new PhotoModelToDTOMapper().mapToModel(k.get(), file);
        }
        catch (Exception e){
            throw e;
        }
    }

    public PhotoModel getPhotoDModelByUserAndAlbumAndPhotoID(Integer userId, Integer albumId, Integer photoId){
        try {
            Optional<UserModel> i = userRepository.findById(userId);
            if (!i.isPresent())
                throw new UserNotFoundException();

            Optional<AlbumModel> j = albumRepository.findById(albumId);
            if(!j.isPresent())
                throw new AlbumNotFoundException();

            Optional<PhotoModel> k = photoRepository.findById(photoId);
            if(!k.isPresent())
                throw new PhotoNotFoundException();

//            URI file = downloadPhotoService.downloadFile(i.get().getUserId() + "-" + j.get().getAlbumID(), k.get().getPhotoName());
//            if (file == null)
//                throw new PhotoNotFoundException();

            return k.get();
        }
        catch (Exception e){
            throw e;
        }
    }

    public PhotoModel getPhotoDModelByUserIdAndAlbumIdAndPhotoName(Integer userId, Integer albumId, String photoname){
        try {
            Optional<UserModel> i = userRepository.findById(userId);
            if (!i.isPresent())
                throw new UserNotFoundException();

            Optional<AlbumModel> j = albumRepository.findById(albumId);
            if(!j.isPresent())
                throw new AlbumNotFoundException();

            Optional<PhotoModel> k = photoRepository.findByUser_UserIdAndAlbum_AlbumIDAndPhotoNameLike(i.get().getUserId(), j.get().getAlbumID(), photoname);
            if(!k.isPresent())
                throw new PhotoNotFoundException();

//            URI file = downloadPhotoService.downloadFile(i.get().getUserId() + "-" + j.get().getAlbumID(), k.get().getPhotoName());
//            if (file == null)
//                throw new PhotoNotFoundException();

            return k.get();
        }
        catch (Exception e){
            throw e;
        }
    }

    public PhotoDTO getPhotoDTOByEmailAndAlbumnameAndPhotoname(String email, String albumname, String photoname){
        try {
            Optional<UserModel> i = userRepository.findByEmailLikeIgnoreCase(email);
            if (!i.isPresent())
                throw new UserNotFoundException();

            Optional<AlbumModel> j = albumRepository.findByUserIdAndAlbumTitle(i.get().getUserId(), albumname);
            if(!j.isPresent())
                throw new AlbumNotFoundException();

            Optional<PhotoModel> k = photoRepository.findByUser_UserIdAndAlbum_AlbumIDAndPhotoNameLike(i.get().getUserId(), j.get().getAlbumID(), photoname);
            if(!k.isPresent())
                throw new PhotoNotFoundException();

            URI file = downloadPhotoService.downloadFile(i.get().getUserId() + "-" + j.get().getAlbumID(), k.get().getPhotoName());
            if (file == null)
                throw new PhotoNotFoundException();

            return new PhotoModelToDTOMapper().mapToModel(k.get(), file);
        }
        catch (Exception e){
            throw e;
        }
    }

    public List<PhotoDTO> getPhotosByUserEmailAndAlbumName(String email, String albumname){
        try {
            List<PhotoDTO> response = new ArrayList<>();

            Optional<UserModel> i = userRepository.findByEmailLikeIgnoreCase(email);
            if (!i.isPresent())
                throw new UserNotFoundException();

            Optional<AlbumModel> j = albumRepository.findByUserIdAndAlbumTitle(i.get().getUserId(), albumname);
            if(!j.isPresent())
                throw new AlbumNotFoundException();

            Optional<List<PhotoModel>> k = photoRepository.findByUser_UserIdAndAlbum_AlbumID(i.get().getUserId(), j.get().getAlbumID());
            if(!k.isPresent())
                throw new PhotoNotFoundException();



            for(PhotoModel mod: k.get()){
                URI file = downloadPhotoService.downloadFile(i.get().getUserId() + "-" + j.get().getAlbumID(), mod.getPhotoName());
                if (file == null)
                    throw new PhotoNotFoundException();

                response.add(new PhotoModelToDTOMapper().mapToModel(mod, file));
            }

            return response;
        }
        catch (Exception e){
            throw e;
        }
    }

    public PhotoModel getPhotoModelById(Integer id){
        try {
            Optional<PhotoModel> i = photoRepository.findById(id);
            if (!i.isPresent())
                throw new PhotoNotFoundException();
            return i.get();
        }
        catch (Exception e){
            throw new PhotoNotFoundException();
        }
    }
}
