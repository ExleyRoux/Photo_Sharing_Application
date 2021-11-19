package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.mapper.UserDTOToModelMapper;
import xyz.ps.repository.AlbumRepository;
import xyz.ps.repository.UserRepository;

@Service
public class CreateNewAlbumService {
    @Autowired
    private AlbumRepository albums;
}


//@Service
//public class CreateNewUserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public void createNewUser(NewUserDTO user){
//        try {
//            userRepository.save(new UserDTOToModelMapper().mapToModel(user));
//        }
//        catch (Exception e){
//            throw new RuntimeException("Unable to save to the DB", e);
//        }
//    }
//}
