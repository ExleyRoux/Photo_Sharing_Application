package xyz.ps.controller.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.NewUserService;

@RestController
@RequestMapping("new-user")
@ComponentScan("xyz.ps.service")
public class NewUserController {

    @Autowired
    private NewUserService userService;

    @PostMapping(name = "CreateNewUser", value = "/")
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


