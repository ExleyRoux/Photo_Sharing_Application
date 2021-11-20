package xyz.ps.model.exception;

public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(){super();}
        public ResourceNotFoundException(String errorMessage, Throwable err){super(errorMessage, err);}
        public ResourceNotFoundException(String errorMessage){super(errorMessage);}
    }
