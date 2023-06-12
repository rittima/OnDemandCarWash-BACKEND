package CG.washer.GreenCarWash.exceptionHandlers;

public class APIrequestException extends RuntimeException{

    public APIrequestException(String message, Throwable cause){
        super(message, cause);
    }

    public APIrequestException(String message){
        super(message);
    }
}
