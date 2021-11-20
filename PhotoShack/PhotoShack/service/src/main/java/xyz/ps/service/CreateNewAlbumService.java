package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.NewAlbumDTO;
import xyz.ps.service.exception.EmailNotFoundException;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;

@Service
public class CreateNewAlbumService {
    @Autowired
    private AlbumRepository albums;
    @Autowired
    private GetUserService userService;

    public AlbumModel createNewAlbum(NewAlbumDTO album) {
        try {
            UserModel user = userService.getUserModelByEmail(album.getUserEmail());
            if(user == null){
                throw new EmailNotFoundException();
            }

            String title = album.getTitle();
            if(title == null || title == ""){
                title = "root";
            }

            AlbumModel i = new AlbumModel();
            i.setUser(user);
            i.setTitle(title);

            return albums.save(i);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
