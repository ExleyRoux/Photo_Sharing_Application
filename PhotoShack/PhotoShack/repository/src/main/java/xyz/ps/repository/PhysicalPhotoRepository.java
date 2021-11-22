package xyz.ps.repository;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public class PhysicalPhotoRepository {

    public static final String storageConnectionString =
                    "DefaultEndpointsProtocol=https;" +
                    "AccountName=30196299;" +
                    "AccountKey=3oivwGoLFyzLlMLRzfjOjZKnsiUEPy8MonOXvONoRAXEfTYgWHiWaMoC+fyod13sulFuYxt39TYPLegzLYCnw==;" +
                    "EndpointSuffix=core.windows.net";



    private CloudStorageAccount storageAccount;
    private File sourceFile = null, downloadedFile = null;
    private CloudBlobClient blobClient;
    private CloudBlobContainer blobContainer;



    public PhysicalPhotoRepository() throws URISyntaxException, InvalidKeyException, StorageException {
        init();
    }

    public void createContainer(String containerName) throws URISyntaxException, StorageException {
        this.blobContainer = getBlobClient().getContainerReference(containerName);
    }

    private void init() throws URISyntaxException, InvalidKeyException {
        System.out.println("Setting Storage Account");
        setStorageAccount();
        System.out.println("Setting Blob client");
        setBlobClient();
    }

    private CloudBlockBlob getBlobReference(String filename) throws URISyntaxException, StorageException {
        CloudBlockBlob i = blobContainer.getBlockBlobReference(filename);
        return i;
    }

    private CloudBlobContainer getAContainerReference(String containerName) throws URISyntaxException, StorageException {
        System.out.println("Getting container reference " + containerName);
        CloudBlobContainer i = getBlobClient().getContainerReference(containerName);
        i.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        return i;
    }

    private CloudBlobClient getBlobClient(){
        System.out.println("Creating blob client");
        if(this.blobClient == null){
            this.blobClient = storageAccount.createCloudBlobClient();
        }
        return this.blobClient;
    }

    private void setBlobClient(CloudBlobClient client){
        this.blobClient = client;
    }

    private void setBlobClient(){
        this.blobClient = getStorageAccount().createCloudBlobClient();
    }

    private CloudStorageAccount getStorageAccount() {
        return this.storageAccount;
    }

    private void setStorageAccount(CloudStorageAccount acc){
        this.storageAccount = acc;
    }

    private void setStorageAccount() throws URISyntaxException, InvalidKeyException {
        setStorageAccount(storageConnectionString);
    }

    private void setStorageAccount(String connectionString) throws URISyntaxException, InvalidKeyException {
        this.storageAccount = CloudStorageAccount.parse(connectionString);
    }

    private CloudBlockBlob getABlockBlobReference(String containername, String filename) throws URISyntaxException, StorageException {

        return getAContainerReference(containername).getBlockBlobReference(filename);
    }

    public CloudBlockBlob uploadNewPhoto(MultipartFile file, String containerName) throws URISyntaxException, StorageException, IOException {
        CloudBlockBlob blob = getABlockBlobReference(getAContainerReference(containerName).getName(), file.getOriginalFilename());

        blob.upload(file.getInputStream(),file.getSize());
        return blob;
    }


}
