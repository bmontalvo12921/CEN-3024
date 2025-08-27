//This class is set up to set the parameters for the username and password, and to throw an exception if the username or password does not meet parameters
public class PasswordVerify {
    private String username;
    private String password;

    public PasswordVerify(String username, String password) throws PasswordVerifyException{
        if (!isValidUsername(username)) {
            throw new PasswordVerifyException("Invalid username: Must be at least 6 characters long and contain at least one special character");
        }
        if (!isValidPassword(password)) {
            throw new PasswordVerifyException("Invalid password: Must contain at least 2 vowels and 2 digits.");
        }
        this.username = username;
        this.password = password;
        }// Validates that the username is at least 6 characters and contains 1 special character
        private boolean isValidUsername(String username) {
            return username.length() >= 6 && username.matches(".*[!@#$%].*");
        }//Validates that passwords contain 2 vowels and 2 digits
        private boolean isValidPassword(String password){
        int vowelCount = 0, digitCount = 0;
        for (char ch : password.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch)>=0 ) vowelCount++;
            if (Character.isDigit(ch)) digitCount++;
        }
        return vowelCount >= 2 && digitCount >=2;

        }//Override method to implement the method we will print out all Users at the end of the program
       @Override
    public String toString() {
        return "Username: " + username + ", Password: [HIDDEN]";
    }
}
