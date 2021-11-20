package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.mapper.UserDTOToModelMapper;
import xyz.ps.model.mapper.UserModelToDTOMapper;
import xyz.ps.repository.UserRepository;

//This is a service to create a new User used by controller
@Service
public class CreateNewUserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createNewUser(NewUserDTO user){
        try {
            return new UserModelToDTOMapper().mapToModel(userRepository.save(new UserDTOToModelMapper().mapToModel(user)));
        }
        catch (Exception e){
            throw new RuntimeException("Could not create new user", e);
        }
    }
}
