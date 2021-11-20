package xyz.ps.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PHOTO_DATA", uniqueConstraints = {
        @UniqueConstraint(name = "uc_photomodel_photo_name", columnNames = {"PHOTO_NAME", "ID_ALBUM"})
})
public class PhotoModel {
    private Integer photoID;
    private String photoName;

    private UserModel user;
    private List<UserModel> sharedUsers;
    private AlbumModel album;

    public PhotoModel() {}
    public PhotoModel(String photoName) {this.photoName = photoName;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PHOTO")
    public Integer getPhotoID(){return photoID;}
    public void setPhotoID(Integer photoID){this.photoID = photoID;}

    @Column(name = "PHOTO_NAME")
    public String getPhotoName(){return photoName;}
    public void setPhotoName(String name){this.photoName = name;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    public UserModel getUser(){return user;}
    public void setUser(UserModel user){this.user = user;}

    @OneToMany(targetEntity = UserModel.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<UserModel> getSharedUsers(){return sharedUsers;}
    public void setSharedUsers(List<UserModel> users){this.sharedUsers = users;}

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALBUM")
    public AlbumModel getAlbum(){return album;}
    public void setAlbum(AlbumModel album){this.album = album;}
}
