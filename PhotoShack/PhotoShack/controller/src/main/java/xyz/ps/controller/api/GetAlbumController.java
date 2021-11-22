package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.service.GeneralResponse;
import xyz.ps.service.GetPhotoService;
import xyz.ps.service.PhysicalPhotoService;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.service.exception.PhotoNotFoundException;
import xyz.ps.service.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("album")
@ComponentScan("xyz.ps.service")
public class GetAlbumController {

    @Autowired
    PhysicalPhotoService physicalPhotoService;
    @Autowired
    GetPhotoService getPhotoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(name = "Get Album Contents", value = "/")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GeneralResponse> getAlbumContents(
            @RequestParam String email,
            @RequestParam String albumname
    ){
        List<PhotoDTO> i = new ArrayList<>();

        String message = "No Problem Found";
        HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
        GeneralResponse response = new GeneralResponse(false, "No Problem Found");

        try {

            i = getPhotoService.getPhotosByUserEmailAndAlbumName(email, albumname);

            status = HttpStatus.OK;
            response.setSuccessful(true);
            response.setPayload(i);
        }
        catch (UserNotFoundException e){
            status = HttpStatus.BAD_REQUEST;
            response.setPayload("User Not Found");
        }
        catch (PhotoNotFoundException e){
            status = HttpStatus.BAD_REQUEST;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch (AlbumNotFoundException e){
            status = HttpStatus.BAD_REQUEST;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch(Exception e){
            status = HttpStatus.BAD_REQUEST;
            response.setPayload("Something Went Wrong ");
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, status);
    }
}
