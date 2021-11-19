package xyz.ps.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ALBUMS")
public class AlbumModel {
    private Integer albumID;
    private String title;

    private List<PhotoModel> photoModelList;
    private UserModel user;

    public AlbumModel() {}
    public AlbumModel(Integer albumID, String title, UserModel user) {
        this.albumID = albumID;
        this.title = title;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ALBUM")
    public Integer getAlbumID(){return albumID;}
    public void setAlbumID(Integer id){this.albumID = id;}

    @Column(name = "ALBUM_NAME")
    public String getTitle(){return title;}
    public void setTitle(String name){this.title = name;}

    @OneToMany(targetEntity = PhotoModel.class, fetch = FetchType.LAZY, mappedBy = "album", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public List<PhotoModel> getPhotoModelList(){return photoModelList;}
    public void setPhotoModelList(List<PhotoModel> photos){this.photoModelList = photos;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    public UserModel getUser(){return user;}
    public void setUser(UserModel user){this.user = user;}
}
