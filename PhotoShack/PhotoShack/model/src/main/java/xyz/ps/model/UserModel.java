package xyz.ps.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private List<AlbumModel> userAlbumsList;
    private List<PhotoModel> userPhotoSharedList;
    private List<AlbumModel> userSharedAlbumsList;

    public UserModel(){};
    public UserModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserModel(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    public Integer getUserId(){return userId;}
    public void setUserId(Integer userId) {this.userId = userId;}

    @Column(name = "FIRST_NAME")
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName(){return lastName;}
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL")
    public String getEmail(){return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASSWORD")
    public String getPassword(){return password;}
    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(targetEntity = PhotoModel.class, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public List<PhotoModel> getUserPhotoSharedList(){return userPhotoSharedList;}
    public void setUserPhotoSharedList(List<PhotoModel> photos){this.userPhotoSharedList = photos;}

    @OneToMany(targetEntity = AlbumModel.class, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public List<AlbumModel> getUserAlbumList(){return userAlbumsList;}
    public void setUserAlbumsList(List<AlbumModel> photos){this.userAlbumsList = photos;}

    @OneToMany(targetEntity = AlbumModel.class, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public List<AlbumModel> getUserSharedAlbumList(){return userSharedAlbumsList;}
    public void setUserSharedAlbumsList(List<AlbumModel> albums){this.userSharedAlbumsList = albums;}
}