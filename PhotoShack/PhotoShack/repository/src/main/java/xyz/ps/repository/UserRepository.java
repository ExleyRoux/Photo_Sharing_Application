package xyz.ps.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import xyz.ps.repository.impl.UserRepositoryQuery;
import xyz.ps.repository.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>, UserRepositoryQuery {

    @Query("select u from UserModel u where upper(u.email) like upper(?1)")
    UserModel findByEmailLikeIgnoreCase(String email);

    @Query("select (count(u) > 0) from UserModel u where u.email = ?1 and u.password = ?2")
    boolean existsByEmailIsAndPassword(String email, String password);

    @Query("select u from UserModel u where upper(u.firstName) like upper(?1)")
    UserModel findByFirstNameLikeIgnoreCase(String firstName);

    @Query("select u from UserModel u where u.userId = ?1")
    UserModel findByUserIdIs(Integer userId);

    @Query("select u from UserModel u where upper(u.email) like upper(?1) and upper(u.password) like upper(?2)")
    UserModel findByEmailAndPassword(@NonNull String email, @NonNull String password);


}
