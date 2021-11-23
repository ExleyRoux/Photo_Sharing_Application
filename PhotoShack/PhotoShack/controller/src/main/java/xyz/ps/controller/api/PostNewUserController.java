package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.CreateNewUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
@ComponentScan("xyz.ps.service")
public class PostNewUserController {

    @Autowired
    private CreateNewUserService userService;

    @PostMapping(name = "CreateNewUser", value = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<GeneralResponse<NewUserDTO>> create(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ){
        NewUserDTO i = new NewUserDTO();
        HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
        GeneralResponse response = new GeneralResponse(false, "No Problem Found");

        try {

            i.setEmail(email);
            i.setFirstName(firstName);
            i.setLastName(lastName);
            i.setPassword(password);

            userService.createNewUser(i);
            status = HttpStatus.CREATED;
            response.setPayload(i);
        }
        catch (Exception e){
            response.setSuccessful(false);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(response, status);
    }
}


