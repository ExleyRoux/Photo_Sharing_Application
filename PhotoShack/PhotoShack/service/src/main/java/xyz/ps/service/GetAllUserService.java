package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.mapper.UserDTOToModelMapper;
import xyz.ps.repository.model.UserModel;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.mapper.UserModelToDTOMapper;
import xyz.ps.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllUserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        List<UserDTO> userDTOS = new ArrayList<>();
        try {
            for(UserModel user: userRepository.findAll()){
                userDTOS.add(new UserModelToDTOMapper().mapToModel(user));
            }
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from database", e);
        }
        return userDTOS;
    }

    public UserDTO getAllUsersId(Integer id){
        try {
            return new UserModelToDTOMapper().mapToModel(userRepository.findByUserIdIs(id));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from database", e);
        }
    }
}
