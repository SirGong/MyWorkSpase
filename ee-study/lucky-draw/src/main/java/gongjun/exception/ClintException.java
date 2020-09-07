package gongjun.exception;

/**
 *
 */
public class ClintException extends BaseException {
    public ClintException(String code, String message) {
        super("CLI"+code, message);
    }

    public ClintException(String code, String message, Throwable cause) {
        super("CLI"+code, message, cause);
    }
}
