package exception;

public class ProjectDataIncorrectException extends Exception {
    public ProjectDataIncorrectException() {
        super();
    }

    public ProjectDataIncorrectException(String message) {
        super(message);
    }

    public ProjectDataIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectDataIncorrectException(Throwable cause) {
        super(cause);
    }
}