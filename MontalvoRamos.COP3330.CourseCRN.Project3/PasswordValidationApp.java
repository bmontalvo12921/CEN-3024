//Bryan Montalvo Ramos
//Course: COP 3330
//2/8/2025
//This program is design to verify username and passwords using exceptions/
//User must enter username with at least 1 special character and the password must contain 2 vowels and 2 digits.
import java.util.InputMismatchException;
import java.util.Scanner;
public class PasswordValidationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordVerify[] users = new PasswordVerify[4];
        int count = 0;
        //print method to explain the rules
        System.out.print("PasswordRules: ");
        System.out.print("1. Username Must be at least 6 characters long and contain at least one special character.\n");
        System.out.print("2. Password must contain at least 2 vowels and 2 digits.");
            //loop to collect valid usernames and passwords for 4 users
          while(count< users.length) {
              try {
                  System.out.print(" \n Enter Username: ");
                  String username = sc.nextLine();
                  System.out.print("Enter Password: ");
                  String password = sc.nextLine();

                  users[count] = new PasswordVerify(username, password);
                  System.out.print("Account created successfully.\n");
                  count++;
              } catch (PasswordVerifyException e) {// this is set up to catch any exceptions from Username and Password
                  System.out.println("Error: " + e.getMessage());// message(must be at least 6 characters long and contain at least one special character
                  System.out.println("Password validation failed, Password must contain 2 vowels and 2 digits");
              } catch (InputMismatchException e) {// this exception is set up to catch any other errors that might occur
                  System.out.println("Invalid input. Please enter valid text.");
                  sc.nextLine();
              }
          }

            //Print method to print out all the Users
            System.out.println("\n All Valid Username and Passwords:");
            for (PasswordVerify user: users){
                    System.out.println(user);
                }
        System.out.println("\n All 4 users created successfully. Exiting Program.\n");
        sc.close();

    }
}
