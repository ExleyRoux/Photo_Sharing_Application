package xyz.ps.repository.model;

public class PhysicalPhotoModel {
    private String imagePath;
    private String filename;
    private MetaDatas metadata;

    public PhysicalPhotoModel(){
        this.imagePath = "/photo/image" + filename;
    }

    private class MetaDatas{
    }
}


