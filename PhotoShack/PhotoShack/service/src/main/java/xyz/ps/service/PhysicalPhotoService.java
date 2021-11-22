package xyz.ps.service;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import com.microsoft.azure.storage.file.CloudFile;
import com.microsoft.azure.storage.file.CloudFileShare;
import com.microsoft.azure.storage.file.FileInputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import xyz.ps.model.exception.ResourceNotFoundException;
import xyz.ps.service.exception.PhotoNotFoundException;

import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhysicalPhotoService {
    public String storageConnectionString;
    private CloudStorageAccount storageAccount;
    private CloudBlobClient blobClient;

    private void init() throws URISyntaxException, InvalidKeyException {
        System.out.println("Init");
        this.storageConnectionString =
                "DefaultEndpointsProtocol=https;" +
                "AccountName=30196299;" +
                "AccountKey=3oivwGoLFyzLlMLRzfjOjZKnsiUEPy8MonOXvONoRAXEfTYgWHiWaMoC+fyod13sulFuYxt39TYPLeg/zLYCnw==;" +
                "EndpointSuffix=core.windows.net";
        System.out.println("Creating storageAccount");
        this.storageAccount = CloudStorageAccount.parse(storageConnectionString);
        System.out.println("Creating blobClient");
        this.blobClient = storageAccount.createCloudBlobClient();
    }

    private CloudBlobContainer getContainer(String containerName) throws URISyntaxException, StorageException {
        System.out.println("Getting container " + containerName);
        CloudBlobContainer i = blobClient.getContainerReference(containerName);
        return i;
    }

    private boolean createContainer(CloudBlobContainer container){
        System.out.println("Creating Container " + container.getName());
        try {
            return container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        } catch (StorageException e) {
            e.printStackTrace();
        }
        return false;
    }

    private CloudBlockBlob getBlob(CloudBlobContainer container, String filename){
        System.out.println("Getting Blob " + container.getName() + " " + filename);
        try {
            CloudBlockBlob blob = getContainer(container.getName()).getBlockBlobReference(filename);
            if (blob.exists()){
                System.out.println("Found");
                return blob;
            }
            else{
                System.out.println("Not Found");
                return blob;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public CloudBlockBlob uploadNewPhoto(MultipartFile file, String containerName) throws URISyntaxException, StorageException, IOException, InvalidKeyException {
        System.out.println("Getting Ready to upload " + containerName + " " + file.getOriginalFilename());
        init();
        CloudBlobContainer contain = getContainer(containerName);
        if(!contain.exists())
            createContainer(contain);
        CloudBlockBlob blob = getBlob(contain, file.getOriginalFilename());

        System.out.println("Uploading " + file.getOriginalFilename() + " to " + containerName);
        blob.upload(file.getInputStream(),file.getSize());
        return blob;
    }

//    public boolean downloadPhoto(String containername, String filename){
//        try {
//            CloudFile cloudFile;
//            init();
//            CloudBlobContainer con = getContainer(containername);
//            if (con.exists()){
//                CloudBlockBlob i = getBlob(con, filename);
//                if (!i.exists())
//                    throw new PhotoNotFoundException();
//                i.download(new OutputStream().);
//                return true;
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (StorageException e) {
//            e.printStackTrace();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }

    public URI getPhotoUri(String container, String filename){
        try {
            init();
            CloudBlockBlob i = getBlob(getContainer(container), filename);
            if (i != null){
                return i.getUri();
            }
            else {
                throw new RuntimeException();
            }
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    public List<String> getAllPhotoUri(String container){
        List<String> list = new ArrayList<>();
        try {
            init();
            for (ListBlobItem i : getContainer(container).listBlobs()){
                list.add(i.getUri().toURL().toString());
            }
            return list;
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void deletePhoto(String containerName, String photoName){
        try {
            init();
            System.out.println("Getting Ready to delete " + containerName + " " + photoName);
            CloudBlobContainer contain = getContainer(containerName);
            if(!contain.exists())
                throw new ResourceNotFoundException();
            CloudBlockBlob blob = getBlob(contain, photoName);

            System.out.println("Deleting " + photoName + " from " + containerName);
            blob.delete();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }



}
