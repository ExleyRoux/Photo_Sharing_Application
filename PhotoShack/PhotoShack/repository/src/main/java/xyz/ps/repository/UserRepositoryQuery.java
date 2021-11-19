package xyz.ps.repository;

import org.springframework.data.jpa.repository.Query;

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
                    "us.email = :email "
    )
    Boolean userExists(String firstname, String lastname, String email);
}
