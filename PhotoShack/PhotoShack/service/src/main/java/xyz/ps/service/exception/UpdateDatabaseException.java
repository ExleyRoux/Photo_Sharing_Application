package xyz.ps.service.exception;

public class UpdateDatabaseException extends RuntimeException{
    public UpdateDatabaseException(){super();}
    public UpdateDatabaseException(String errorMessage, Throwable err){super(errorMessage, err);}
    public UpdateDatabaseException(String errorMessage){super(errorMessage);}
}
