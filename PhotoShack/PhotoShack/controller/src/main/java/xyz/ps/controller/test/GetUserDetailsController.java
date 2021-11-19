package xyz.ps.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.service.GetAllUserService;
import xyz.ps.service.GetUserExistsService;

import java.util.*;

@RestController
@RequestMapping("user")
@ComponentScan("xyz.ps.service")
public class GetUserDetailsController {

    @Autowired
    private GetAllUserService getAllUserService;
    private GetUserExistsService getUserExistsService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> response = new ArrayList<>();
        try{
            response = getAllUserService.getAllUsers();
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user")
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Boolean> isUser(@RequestBody UserDTO user){
        Boolean result = false;
        try{
            result = getUserExistsService.isUser(user);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @GetMapping("/id")
//    @ResponseBody
//    public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO user){
//        UserDTO response = new UserDTO();
//        try{
//            response = getUserExistsService.getUser();
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
