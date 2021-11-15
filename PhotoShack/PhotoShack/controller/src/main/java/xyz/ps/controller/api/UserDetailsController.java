package xyz.ps.controller.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.GetAllUserService;

import java.util.*;

@RestController
@RequestMapping("user")
@ComponentScan("xyz.ps.service")
public class UserDetailsController {

    @Autowired
    private GetAllUserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> response = new ArrayList<>();
        try{
            response = userService.getAllUsers();
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
