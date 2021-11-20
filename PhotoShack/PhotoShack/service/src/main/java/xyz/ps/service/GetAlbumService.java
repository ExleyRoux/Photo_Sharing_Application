package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;

import java.util.List;

@Service
public class GetAlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumModel getAlbumByUserAndAlbumName(UserModel user, String album){
        try {
            return albumRepository.findByUserIsAndTitleLikeIgnoreCase(user, album);
        }
        catch (Exception e){
            throw new RuntimeException("Can't connect to database");
        }
    }

    public List<AlbumModel> getAlbumListByUser(UserModel user) {
        try {
            return albumRepository.findByUser(user);
        }
        catch (Exception e){
            throw new RuntimeException("Can't connect to database");
        }
    }
}
