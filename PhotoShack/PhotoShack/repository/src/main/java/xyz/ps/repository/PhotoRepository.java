package xyz.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.PhotoModel;
import xyz.ps.repository.model.UserModel;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoModel, Integer> {
    @Modifying
    @Query("delete from PhotoModel p where p.user = :user and p.album = :album and p.photoName like :photoName")
    int deleteByUserIsAndAlbumAndPhotoNameLike(@Param("user") UserModel user, @Param("album") AlbumModel album, @Param("photoName") String photoName);

    @Query("select p from PhotoModel p where p.user = ?1 and p.album = ?2 and p.photoName like ?3")
    PhotoModel findByUserAndAlbumAndPhotoNameLike(UserModel user, AlbumModel album, String photoName);
}