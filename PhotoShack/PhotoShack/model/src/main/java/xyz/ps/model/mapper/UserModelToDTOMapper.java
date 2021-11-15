package xyz.ps.model.mapper;

import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.UserModel;

//This class maps the request body to the DTO
public class UserModelToDTOMapper {
    public UserDTO mapToModel(UserModel user){
        UserDTO i = new UserDTO();

        i.setEmail(user.getEmail());
        i.setFirstName(user.getFirstName());
        i.setLastName(user.getLastName());
        return i;
    }
}
