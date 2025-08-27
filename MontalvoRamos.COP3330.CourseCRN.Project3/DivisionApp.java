 //Bryan Montalvo Ramos
 //Course: COP 3330
 //Date: 2/8/2025

 //This program divides two integers provided by the user.
 //If the user attempts to divide by zero, an ArithmeticException is caught and handled.
 //The result is displayed with 2 decimal places.
 import java.util.Scanner;
import java.util.InputMismatchException;
public class DivisionApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Get user input
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Perform division and handle exception
            double result = divideNumbers(num1, num2);
            System.out.printf("Result: %d / %d = %.2f\n", num1, num2, result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");

        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }

   // Arithmetic method explain below
    //If numerator is divided by 0 the program will throw exception
    public static double divideNumbers(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (double) num1 / num2;
    }
}
