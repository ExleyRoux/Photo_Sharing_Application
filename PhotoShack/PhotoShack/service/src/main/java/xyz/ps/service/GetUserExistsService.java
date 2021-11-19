package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.UserModel;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.mapper.UserDTOToModelMapper;
import xyz.ps.repository.UserRepository;


@Service
public class GetUserExistsService {

    @Autowired
    private UserRepository userRepository;

    public Boolean isUser(UserDTO user){
        try {
            UserModel i = new UserDTOToModelMapper().mapToModel(user);
            return userRepository.userExists(
                    i.getFirstName(),
                    i.getLastName(),
                    i.getEmail()
            );
        }
        catch (Exception e){
            throw new RuntimeException("Could not connect to database", e);
        }
    }

}
