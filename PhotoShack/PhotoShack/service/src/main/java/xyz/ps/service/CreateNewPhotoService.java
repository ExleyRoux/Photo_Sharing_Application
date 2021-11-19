package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.NewUserDTO;
import xyz.ps.model.mapper.PhotoDTOToModelMapper;
import xyz.ps.model.mapper.PhotoModelToDTOMapper;
import xyz.ps.model.mapper.UserDTOToModelMapper;
import xyz.ps.repository.PhotoRepository;

@Service
public class CreateNewPhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public void createNewPhoto(NewPhotoDTO newPhotoDTO){
        try {
            photoRepository.save(new PhotoDTOToModelMapper().mapToModel(newPhotoDTO));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
