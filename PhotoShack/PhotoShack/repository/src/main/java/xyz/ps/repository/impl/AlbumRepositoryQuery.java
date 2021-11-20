package xyz.ps.repository.impl;

import org.springframework.data.jpa.repository.Query;
import xyz.ps.repository.model.AlbumModel;
import xyz.ps.repository.model.UserModel;

public interface AlbumRepositoryQuery {

    @Query(
            value =
                    "SELECT " +
                    "am " +
                    "FROM "+
                    "AlbumModel am "+
                    "WHERE " +
                    "am.title = :albumName AND " +
                    "am.user = :user"
    )
    AlbumModel getAlbum(UserModel user, String albumName);
}
