package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.NewAlbumDTO;
import xyz.ps.service.exception.UserNotFoundException;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;

@Service
public class CreateNewAlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private GetUserService getUserService;

    public AlbumModel createNewAlbum(NewAlbumDTO album) {
        try {
            UserModel user = getUserService.getUserById(album.getUserId());

            String title = album.getTitle();
            if(title == null || title == ""){
                title = "root";
            }

            AlbumModel i = new AlbumModel();
            i.setUser(user);
            i.setTitle(title);

            return albumRepository.save(i);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
