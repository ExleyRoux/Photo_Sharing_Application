package xyz.ps.service.exception;

public class PhotoNotFoundException extends RuntimeException {
    public PhotoNotFoundException() {
        super();
    }

    public PhotoNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public PhotoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
