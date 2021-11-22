package xyz.ps.service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){super();}
    public UserNotFoundException(String errorMessage, Throwable err){super(errorMessage, err);}
    public UserNotFoundException(String errorMessage){super(errorMessage);
    }
}
