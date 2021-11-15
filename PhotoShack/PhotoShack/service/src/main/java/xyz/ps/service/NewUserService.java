package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.mapper.UserModelMapper;
import xyz.ps.repository.persistence.UserRepository;

//This is a service to create a new User used by controller
@Service
public class NewUserService {

    @Autowired
    private UserRepository userRepository;

    public void createNewUser(UserDTO user){
        try {
            userRepository.save(new UserModelMapper().mapToModel(user));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
