package xyz.ps.model.exception;

public class EmailNotFoundException extends RuntimeException{
    public EmailNotFoundException(){super();}
    public EmailNotFoundException(String errorMessage, Throwable err){super(errorMessage, err);}
    public EmailNotFoundException(String errorMessage){super(errorMessage);}
}
