package exception;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message){
        super(message);
    }
    public ApiRequestException(String message, Throwable cause){
        super(message, cause);
    }
    public ApiRequestException(long order_id){
        super("Delete Success" + order_id);
    }
}
