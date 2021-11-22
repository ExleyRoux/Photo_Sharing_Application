package xyz.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumModel, Integer> {
    @Query("select a from AlbumModel a where a.user.userId = ?1 and a.title like ?2")
    Optional<AlbumModel> findByUserIdAndAlbumTitle(Integer userId, String title);

    @Query("select a from AlbumModel a where a.user = ?1")
    List<AlbumModel> findByUser(UserModel user);
}
