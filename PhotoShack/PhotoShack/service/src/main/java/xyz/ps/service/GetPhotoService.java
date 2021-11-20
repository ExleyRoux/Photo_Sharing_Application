package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.repository.PhotoRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;

@Service
public class GetPhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public PhotoModel getPhotoByUserAndAlbumAndPhotoName(UserModel user, AlbumModel album, String photoName){
        try {
            return photoRepository.findByUserAndAlbumAndPhotoNameLike(user, album, photoName);
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }
}
