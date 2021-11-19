package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.AlbumModel;
import xyz.ps.model.UserModel;
import xyz.ps.repository.AlbumRepository;

@Service
public class GetAlbumService {

//    @Autowired
//    private AlbumRepository albumRepository;
//
//    public AlbumModel getAlbum(UserModel user, String albumName){
//        try {
//            return albumRepository.getAlbum(user, albumName);
//        }
//        catch (Exception e){
//            throw new RuntimeException("Can't connect to database");
//        }
//    }
}
