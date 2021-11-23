package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.LoginUserDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.exception.ResourceNotFoundException;
import xyz.ps.model.mapper.UserModelToDTOMapper;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.GetUserService;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.service.exception.PhotoNotFoundException;
import xyz.ps.service.exception.UserNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("login")
@ComponentScan("xyz.ps.service")
public class GetUserLoginController {

    @Autowired
    GetUserService getUserService;

    @GetMapping(name = "getUser", value = "/")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GeneralResponse> getPhoto(
            @RequestParam String email,
            @RequestParam String password
    ){


        UserDTO i = new UserDTO();
        String message = "No Problem Found";
        HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
        GeneralResponse response = new GeneralResponse(false, "No Problem Found");

        try {

            if(!getUserService.userExists(email)){
                message = "User Does Not Exist";
                status = HttpStatus.NOT_FOUND;
                throw new ResourceNotFoundException();
            }

            UserModel j = getUserService.getUserModelByEmailAndPassword(email, password);
            i = new UserModelToDTOMapper().mapToModel(j);

            status = HttpStatus.OK;
            response.setSuccessful(true);
            response.setPayload(i);
        }
        catch (UserNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("User Not Found");
        }
        catch (PhotoNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch (AlbumNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch(Exception e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("Something Went Wrong");
        }
        return new ResponseEntity<>(response, status);
    }


}
