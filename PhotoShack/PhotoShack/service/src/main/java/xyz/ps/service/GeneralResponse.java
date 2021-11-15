package xyz.ps.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse <T> implements Serializable {
    private static final long serialVersionUID = 736511190197986812L;
    private boolean successful;
    private transient T payload;

    public GeneralResponse(boolean successful, T payload) {
        this.successful = successful;
        this.payload = payload;
    }

    public GeneralResponse() {
        this.successful = false;
        this.payload = null;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public T getPayload() {
        return payload;
    }

    public void setSuccessful(boolean result){
        this.successful = result;
    }

    public void setPayload(T payload){this.payload = payload;}


    @Override
    public boolean equals(Object o) {
        if(this == o)
        {
            return true;
        }
        if(o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return successful == that.successful && Objects.equals(this.payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(successful, payload);
    }

    @Override
    public String toString() {
        return "xyz.ps.service.GeneralResponse{" +
                "successful=" + successful +
                ", payload=" + payload +
                '}';
    }
}