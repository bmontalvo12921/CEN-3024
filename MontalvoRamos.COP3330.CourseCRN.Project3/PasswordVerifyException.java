// Custom exception class for handling invalid username and passwords
public class PasswordVerifyException extends Exception{
    public PasswordVerifyException(String message){
        super(message);
    }
}
