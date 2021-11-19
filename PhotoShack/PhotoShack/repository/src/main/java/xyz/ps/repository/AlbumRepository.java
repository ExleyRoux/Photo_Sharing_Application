package xyz.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.ps.model.AlbumModel;
import xyz.ps.model.UserModel;
import xyz.ps.repository.impl.AlbumRepositoryQuery;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumModel, Integer>, AlbumRepositoryQuery {

}
