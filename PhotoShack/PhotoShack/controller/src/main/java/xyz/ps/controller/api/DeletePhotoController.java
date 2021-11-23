package xyz.ps.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ps.model.dto.DeletePhotoDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.model.exception.ResourceNotFoundException;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;
import xyz.ps.service.*;
import xyz.ps.service.exception.AlbumNotFoundException;
import xyz.ps.service.exception.PhotoNotFoundException;
import xyz.ps.service.exception.UserNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("photo")
@ComponentScan("xyz.ps.service")
public class DeletePhotoController {

    @Autowired
    private DeletePhotoService deletePhotoService;
    @Autowired
    private GetUserService getUserService;
    @Autowired
    private GetAlbumService getAlbumService;
    @Autowired
    private GetPhotoService getPhotoService;

    @DeleteMapping(name = "Delete Photo", value = "/delete")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GeneralResponse> deletePhoto(
            @RequestParam String email,
            @RequestParam String album,
            @RequestParam String photo
    ){
        PhotoDTO i = new PhotoDTO();
        HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
        GeneralResponse response = new GeneralResponse(false, "No Problem Found");

        try {
            UserModel um = getUserService.getUserModelByEmail(email);
            AlbumModel am = getAlbumService.getAlbumByUserIdAndAlbumName(um.getUserId(), album);
            PhotoModel pm = getPhotoService.getPhotoDModelByUserIdAndAlbumIdAndPhotoName(um.getUserId(), am.getAlbumID(), photo);

            if(!deletePhotoService.deletePhotoById(pm.getPhotoID())){
                throw new ResourceNotFoundException();
            }
        }
        catch (UserNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("User Not Found");
        }
        catch (PhotoNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch (AlbumNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch (ResourceNotFoundException e){
            status = HttpStatus.NOT_FOUND;
            response.setPayload("Photo Could Not Be Retrieved");
        }
        catch(Exception e){
            status = HttpStatus.FORBIDDEN;
            response.setPayload("Something Went Wrong");
        }
        return new ResponseEntity<>(response, status);
    }
}
