package xyz.ps.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ALBUMS")
public class AlbumModel {
    private Integer albumID;
    private String albumName;

    private List<PhotoModel> photoList;
    private UserModel user;

    public AlbumModel() {}
    public AlbumModel(Integer albumID, String albumName, UserModel user) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ALBUM")
    public Integer getAlbumID(){return albumID;}
    public void setPhotoID(Integer id){this.albumID = id;}

    @Column(name = "ALBUM_NAME")
    public String getAlbumName(){return albumName;}
    public void setAlbumName(String name){this.albumName = name;}

    @OneToMany(targetEntity = PhotoModel.class, fetch = FetchType.LAZY, mappedBy = "album", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public List<PhotoModel> getPhotoList(){return photoList;}
    public void setPhotoList(List<PhotoModel> photos){this.photoList = photos;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    public UserModel getUser(){return user;}
    public void setUser(UserModel user){this.user = user;}
}
