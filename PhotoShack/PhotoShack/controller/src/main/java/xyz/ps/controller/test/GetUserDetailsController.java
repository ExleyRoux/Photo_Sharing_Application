package xyz.ps.controller.test;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.LoginUserDTO;
import xyz.ps.model.dto.UserDTO;
import xyz.ps.model.mapper.UserModelToDTOMapper;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.GetAllUserService;
import xyz.ps.service.GetUserExistsService;
import xyz.ps.service.GetUserService;

import java.util.*;

@RestController
@RequestMapping("GetUser")
@ComponentScan("xyz.ps.service")
public class GetUserDetailsController {

    @Autowired
    private GetAllUserService getAllUserService;
    @Autowired
    private GetUserExistsService getUserExistsService;
    @Autowired
    private GetUserService getUserService;

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

    @GetMapping("/isUser")
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

    @GetMapping("/getUserById")
    @ResponseStatus(HttpStatus.FOUND)
    @ResponseBody
    public ResponseEntity<GeneralResponse<UserDTO>> getUserById(@ApiParam(required = true) @RequestParam Integer user){
        GeneralResponse response = new GeneralResponse(false, user);
        try{
            UserDTO i = getUserService.getUserById(user);
            response.setPayload(i);
            response.setSuccessful(true);
            return new ResponseEntity<GeneralResponse<UserDTO>>(response, HttpStatus.FOUND);


//            UserDTO i = new UserModelToDTOMapper().mapToModel(getUserService.getUserByLogin(user));
//
//            response.setPayload(i);
//            response.setSuccessful(true);
//
//            return new ResponseEntity<GeneralResponse<UserDTO>>(response, HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<GeneralResponse<UserDTO>>(response ,HttpStatus.BAD_REQUEST);
        }
    }
}
