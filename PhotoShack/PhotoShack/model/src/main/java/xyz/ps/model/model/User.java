package xyz.ps.model.model;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User(){};

    public User(Integer userId, String firstName, String lastName, String userName, String password) {
        this.userId = userId;
        this.firstName = userName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(String firstName, String lastName, String userName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    public Integer getUserId(){return userId;}

    @Column(name = "FIRST_NAME")
    public String getFirstName(){return firstName;}

    @Column(name = "LAST_NAME")
    public String getLastName(){return lastName;}

    @Column(name = "USERNAME")
    public String getUserName(){return userName;}

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, userName, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}