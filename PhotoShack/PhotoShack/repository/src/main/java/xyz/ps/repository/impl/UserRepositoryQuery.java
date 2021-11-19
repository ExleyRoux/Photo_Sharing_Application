package xyz.ps.repository.impl;

import org.springframework.data.jpa.repository.Query;
import xyz.ps.model.UserModel;

public interface UserRepositoryQuery {

    @Query(
            value =
                    "SELECT " +
                    "COUNT(1) " +
                    "FROM "+
                    "UserModel us "+
                    "WHERE " +
                    "us.firstName = :firstname AND " +
                    "us.lastName = :lastname AND "+
                    "us.email = :email AND "+
                    "us.password = :password"
    )
    Integer userExists(String firstname, String lastname, String email, String password);

    @Query(
            value =
                    "SELECT " +
                    "* " +
                    "FROM "+
                    "UserModel us "+
                    "WHERE " +
                    "us.email = :email"
    )
    UserModel getUser(String email);
}
