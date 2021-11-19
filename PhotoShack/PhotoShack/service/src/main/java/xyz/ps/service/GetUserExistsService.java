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
            Integer userCount =
                userRepository.userExists(
                        i.getFirstName(),
                        i.getLastName(),
                        i.getEmail(),
                        i.getPassword()
                );
            if (userCount == 0){
                return false;
            }
            else if(userCount == 1){
                return true;
            }
            else if(userCount > 0){
                throw new RuntimeException("More than a single user found of user given");
            }
            else {
                throw new RuntimeException("An error occurred connecting to the database");
            }
        }
        catch (Exception e){
            throw new RuntimeException("Could not connect to database", e);
        }
    }

}
