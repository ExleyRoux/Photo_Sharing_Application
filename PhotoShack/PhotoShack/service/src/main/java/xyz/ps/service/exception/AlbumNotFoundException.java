package xyz.ps.service.exception;

public class AlbumNotFoundException extends RuntimeException{
    public AlbumNotFoundException(){super();}
    public AlbumNotFoundException(String errorMessage, Throwable err){super(errorMessage, err);}
    public AlbumNotFoundException(String errorMessage){super(errorMessage);}
}
