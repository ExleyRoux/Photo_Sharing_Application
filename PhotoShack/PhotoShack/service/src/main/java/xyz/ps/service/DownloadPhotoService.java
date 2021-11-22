package xyz.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import xyz.ps.model.dto.PhotoDTO;

import javax.persistence.Id;
import java.io.File;
import java.net.URI;
import java.util.concurrent.locks.ReadWriteLock;

@Service
public class DownloadPhotoService {

    @Autowired
    PhysicalPhotoService physicalPhotoService;

    public URI downloadFile(String containername, String filename){
        return physicalPhotoService.getPhotoUri(containername, filename);
    }
}
