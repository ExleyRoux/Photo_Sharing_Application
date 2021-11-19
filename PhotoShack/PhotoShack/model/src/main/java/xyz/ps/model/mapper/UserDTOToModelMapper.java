package xyz.ps.model.mapper;

import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.UserModel;

//This class maps the User DTOs to the Model
public class UserDTOToModelMapper {

    public UserModel mapToModel(UserDTO userDTO){
        UserModel i = new UserModel();
        i.setFirstName(userDTO.getFirstName());
        i.setLastName(userDTO.getLastName());
        i.setEmail(userDTO.getEmail());
        return i;
    }

    public UserModel mapToModel(NewUserDTO userDTO){
        UserModel i = new UserModel();
        i.setFirstName(userDTO.getFirstName());
        i.setLastName(userDTO.getLastName());
        i.setEmail(userDTO.getEmail());
        i.setPassword(userDTO.getPassword());
        return i;
    }
}
