package xyz.ps.repository.impl;

import org.springframework.data.jpa.repository.Query;

public interface AlbumRepositoryQuery {

    @Query(
            value =
                    "SELECT " +
                    "* " +
                    "FROM "+
                    "AlbumModel am "+
                    "WHERE " +
                    "am.title = :albumName AND " +
                    "am.user = :user"
    )
    AlbumModel getAlbum(UserModel user, String albumName);
}
