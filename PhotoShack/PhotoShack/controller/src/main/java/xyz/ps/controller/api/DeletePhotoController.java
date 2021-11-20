package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.DeletePhotoDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.service.DeletePhotoService;
import xyz.ps.service.GeneralResponse;

@RestController
@RequestMapping("photo")
@ComponentScan("xyz.ps.service")
public class DeletePhotoController {

    @Autowired
    private DeletePhotoService deletePhotoService;

    @DeleteMapping(name = "Delete Photo", value = "/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GeneralResponse> deletePhoto(
            @RequestBody DeletePhotoDTO newPhotoDTO){
        try {
            GeneralResponse<PhotoDTO> i = new GeneralResponse(true, deletePhotoService.deletePhoto(newPhotoDTO));
            return new ResponseEntity<GeneralResponse>(i, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new GeneralResponse(false, newPhotoDTO), HttpStatus.BAD_REQUEST);
        }
    }

}
