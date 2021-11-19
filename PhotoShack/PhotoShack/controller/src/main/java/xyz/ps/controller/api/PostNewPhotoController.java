package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.service.CreateNewPhotoService;
import xyz.ps.service.GeneralResponse;

@RestController
@RequestMapping("upload")
@ComponentScan("xyz.ps.service")
public class PostNewPhotoController {

    @Autowired
    private CreateNewPhotoService photoService;

    @PostMapping(name = "Upload Photo", value = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<GeneralResponse<NewPhotoDTO>> create(
            @RequestBody NewPhotoDTO photo){
        GeneralResponse<NewPhotoDTO> response = new GeneralResponse<NewPhotoDTO>(true, photo);
        try {
            photoService.createNewPhoto(photo);
        }
        catch (Exception e){
            response.setSuccessful(false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
