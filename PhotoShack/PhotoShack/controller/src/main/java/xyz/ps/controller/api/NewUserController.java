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
    @ApiOperation(value = "Create New User", notes = "Creates a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Creation of member was successful", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<UserDTO>> create(
            @ApiParam(
                    value = "Request body to create new account type.",
                    required = true
            )
            @RequestBody UserDTO user){
        GeneralResponse<UserDTO> response = new GeneralResponse<UserDTO>(true, user);
        try {
            new NewUserService().createNewUser(user);
        }
        catch (Exception e){
            response.setSuccessful(false);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}


