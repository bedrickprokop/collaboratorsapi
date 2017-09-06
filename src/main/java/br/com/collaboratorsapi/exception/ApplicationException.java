package br.com.collaboratorsapi.exception;

public class ApplicationException extends RuntimeException {

    private String message;
    private Integer statusCode;

    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }

    public ApplicationException(String message, Integer statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    public ApplicationException(Throwable cause, String message, Integer statusCode) {
        super(message, cause);
        this.message = message;
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
