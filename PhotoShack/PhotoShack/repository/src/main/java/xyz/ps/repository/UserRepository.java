package xyz.ps.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.ps.model.*;
import xyz.ps.repository.impl.UserRepositoryQuery;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>, UserRepositoryQuery {
}
