package gongjun.exception;

public class SystemException extends BaseException {
    public SystemException(String code, String message) {
        super("Sys"+code, message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("Sys"+code, message, cause);
    }
}
