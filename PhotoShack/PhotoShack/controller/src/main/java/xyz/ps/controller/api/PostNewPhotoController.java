package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.model.mapper.PhotoModelToDTOMapper;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.CreateNewPhotoService;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.GetAlbumService;
import xyz.ps.service.GetUserService;

import javax.validation.Valid;
import java.io.File;

@RestController
@RequestMapping("upload")
@ComponentScan("xyz.ps.service")
public class PostNewPhotoController {

    @Autowired
    private CreateNewPhotoService createNewPhotoService;
    @Autowired
    private GetUserService getUserService;
    @Autowired
    private GetAlbumService getAlbumService;

    @CrossOrigin("*")
    @PostMapping(name = "Upload Photo", value = "/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<GeneralResponse> create(
            @RequestParam String email,
            @RequestParam String album,
            @RequestParam MultipartFile file
    ){
        NewPhotoDTO i = new NewPhotoDTO();
        String message = "No Problems Found";
        HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
        new GeneralResponse<>(false, message);

        try {
            i.setPhoto(file);
            UserModel um = getUserService.getUserModelByEmail(email);
            AlbumModel am = getAlbumService.getAlbumByUserIdAndAlbumName(um.getUserId(), album);

            PhotoDTO photoDTO = createNewPhotoService.createNewPhoto(i);
            return new ResponseEntity<>(new GeneralResponse(true, photoDTO), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new GeneralResponse(false, i), HttpStatus.BAD_REQUEST);
        }
    }
}
