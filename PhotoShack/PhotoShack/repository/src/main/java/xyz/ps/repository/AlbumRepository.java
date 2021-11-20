package xyz.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.ps.repository.impl.AlbumRepositoryQuery;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumModel, Integer>, AlbumRepositoryQuery {
    @Query("select a from AlbumModel a where a.user = ?1 and upper(a.title) like upper(?2)")
    AlbumModel findByUserIsAndTitleLikeIgnoreCase(UserModel user, String title);

    @Query("select a from AlbumModel a where a.user = ?1")
    List<AlbumModel> findByUser(UserModel user);
}
