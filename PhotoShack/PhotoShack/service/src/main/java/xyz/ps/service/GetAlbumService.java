package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.exception.AlbumNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class GetAlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumModel getAlbumByUserIdAndAlbumName(Integer userid, String album){
        try {
            Optional<AlbumModel> i = albumRepository.findByUserIdAndAlbumTitle(userid, album);
            if (!i.isPresent()){
                throw new AlbumNotFoundException();
            }
            else
                return i.get();
        }
        catch (Exception e){
            throw new AlbumNotFoundException("Can't connect to database");
        }
    }

    public List<AlbumModel> getAlbumListByUser(UserModel user) {
        try {
            return albumRepository.findByUser(user);
        }
        catch (Exception e){
            throw new AlbumNotFoundException("Could Not Find Album");
        }
    }

    public AlbumModel getAlbumByAlbumId(Integer albumId) {
        try {
            Optional<AlbumModel> i = albumRepository.findById(albumId);
            if (!i.isPresent())
                throw new AlbumNotFoundException();
            else
                return i.get();
        }
        catch (Exception e){
            throw new AlbumNotFoundException("Could Not Find Album");
        }
    }
}
