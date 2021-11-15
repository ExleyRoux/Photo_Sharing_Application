package xyz.ps.model.mapper;

import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.UserModel;

//This class maps the DTO to the Model
public class UserModelMapper {

    public UserModel mapToModel(UserDTO userDTO){
        UserModel i = new UserModel();

        i.setFirstName(userDTO.getFirstName());
        i.setLastName(userDTO.getLastName());
        i.setEmail(userDTO.getEmail());
        i.setPassword(userDTO.getPassword());

        return i;
    }
}
