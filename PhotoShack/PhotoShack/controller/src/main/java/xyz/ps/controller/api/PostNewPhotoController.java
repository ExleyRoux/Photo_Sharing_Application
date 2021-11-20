package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.model.mapper.PhotoModelToDTOMapper;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.service.CreateNewPhotoService;
import xyz.ps.service.GeneralResponse;

@RestController
@RequestMapping("upload")
@ComponentScan("xyz.ps.service")
public class PostNewPhotoController {

    @Autowired
    private CreateNewPhotoService photoService;


    @PostMapping(name = "Upload Photo", value = "/upload")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<GeneralResponse> create(@RequestBody NewPhotoDTO photo){
        try {
            PhotoDTO photoDTO = photoService.createNewPhoto(photo);
            return new ResponseEntity<>(new GeneralResponse(true, photoDTO), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new GeneralResponse(false, photo), HttpStatus.BAD_REQUEST);
        }
    }
}
