package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.mapper.UserDTOToModelMapper;
import xyz.ps.repository.persistence.UserRepository;

//This is a service to create a new User used by controller
@Service
public class NewUserService {

    @Autowired
    private UserRepository userRepository;

    public void createNewUser(NewUserDTO user){
        try {
            userRepository.save(new UserDTOToModelMapper().mapToModel(user));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
