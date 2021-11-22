package xyz.ps.service;

import com.microsoft.azure.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.ps.model.dto.NewPhotoDTO;
import xyz.ps.model.dto.PhotoDTO;
import xyz.ps.repository.PhysicalPhotoRepository;
import xyz.ps.repository.model.PhotoModel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Service
public class UploadNewPhotoService {

    @Autowired
    private PhysicalPhotoService physicalPhotoService;

    public void UploadNewPhoto(MultipartFile photo, String containerName) throws URISyntaxException, IOException, StorageException, InvalidKeyException {
        System.out.println("Photo Being Uploaded " + photo.getOriginalFilename() + " " + containerName);
        physicalPhotoService.uploadNewPhoto(photo, containerName);
    }

}
