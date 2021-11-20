package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.LoginUserDTO;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.mapper.UserModelToDTOMapper;
import xyz.ps.repository.model.UserModel;
import xyz.ps.repository.UserRepository;

import java.util.Optional;

@Service
public class GetUserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserDTOByEmail(String email){
        try {
            UserDTO i = new UserModelToDTOMapper().mapToModel(userRepository.findByEmailLikeIgnoreCase(email));
            if(i == null){
                throw new RuntimeException("No user with email "+ email + " found");
            }
            else
                return i;
        }
        catch (Exception e){
            throw new RuntimeException("Problem Finding User");
        }
    }

    public UserModel getUserModelByEmail(String email){
        try {
            UserModel i = userRepository.findByEmailLikeIgnoreCase(email);
            if(i == null){
                throw new RuntimeException("No user with email "+ email + " found");
            }
            else
                return i;
        }
        catch (Exception e){
            throw new RuntimeException("Problem Finding User");
        }
    }

    public UserDTO getUserByName(String name){
        try {
            UserModel j = userRepository.findByFirstNameLikeIgnoreCase(name);
            if(j == null){
                throw new RuntimeException("No user with name "+ name + " found");
            }
            else
                return new UserModelToDTOMapper().mapToModel(j);
        }
        catch (Exception e){
            throw new RuntimeException("Problem Finding User");
        }
    }

    public UserDTO getUserById(Integer id){
        try {
            Optional<UserModel> j = Optional.ofNullable(userRepository.findByUserIdIs(id));
            if(!j.isPresent()){
                throw new UsernameNotFoundException("No user with id "+ id + " found");
            }
            else{
                UserDTO i = new UserModelToDTOMapper().mapToModel(j.get());
                return i;
            }
        }
        catch (Exception e){
            throw new RuntimeException("Problem Finding User");
        }
    }

    public UserModel getUserByLogin(LoginUserDTO user){
        try {
            Optional<UserModel> j = Optional.ofNullable(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()));

            if(!j.isPresent()){
                return new UserModel();
            }
            else
                return j.get();
        }
        catch (Exception e){
            throw new RuntimeException("Problem Finding User", e);
        }
    }
}
