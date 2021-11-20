package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.NewAlbumDTO;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.service.CreateNewAlbumService;
import xyz.ps.service.GeneralResponse;

@RestController
@RequestMapping("album")
@ComponentScan("xyz.ps.service")
public class PostNewAlbumController {

    @Autowired
    private CreateNewAlbumService albumService;

    @PostMapping(name = "New Album", value = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<GeneralResponse<NewAlbumDTO>> create(
            @RequestBody NewAlbumDTO album){
        GeneralResponse<NewAlbumDTO> response = new GeneralResponse<NewAlbumDTO>(true, album);
        try {
            albumService.createNewAlbum(album);
        }
        catch (Exception e){
            response.setSuccessful(false);
//            throw new RuntimeException(e);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
