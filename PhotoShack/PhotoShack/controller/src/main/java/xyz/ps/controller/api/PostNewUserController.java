package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.CreateNewUserService;

@RestController
@RequestMapping("user")
@ComponentScan("xyz.ps.service")
public class PostNewUserController {

    @Autowired
    private CreateNewUserService userService;

    @PostMapping(name = "CreateNewUser", value = "/Register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<GeneralResponse<NewUserDTO>> create(@RequestBody NewUserDTO user){

        GeneralResponse<NewUserDTO> response = new GeneralResponse<NewUserDTO>(true, user);
        try {
            userService.createNewUser(user);
        }
        catch (Exception e){
            response.setSuccessful(false);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}


