import java.util.Scanner;

//Bryan Montalvo Ramos
//COP 3330C-24217
//1/30/2025
public class MechanicApp {//The MechanicApp class demonstrates the interaction between employees and vehicles.

    //It uses arrays to store vehicle details
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Vehicle Array with full entire vehicle details.
        Vehicle[] vehicles = {
                new Vehicle("Car", " Hyundai ", " Genesis Coupe ", 2012, 100000),
                new Vehicle("Car", " Mini Cooper ", " Clubman ", 2016, 75000),
                new Vehicle("Motorcycle", " Honda ", " Shadow Spirit ", 2009, 10000)
        };

        //Overloaded Constructors setting up the values for Employee's
        Employee M1 = new Employee(" Mike ", " Maintenace");
        TeamLead Ron = new TeamLead(" Ron ", " Quality Control");
        Employee M2 = new Employee(" Harry", " Mechanic");

        //Interactive User program to pull information and implement different scenarios according to predetermine parameters
        boolean exitProgram = false;
        while (!exitProgram) {
            // Main menu options
            System.out.println(" === Mechanic Shop Main Menu === ");
            System.out.println("1. Service a Vehicle");
            System.out.println("2. Employee Details");
            System.out.println("3. Current Manager");
            System.out.println("4. Exit Program");
            System.out.println("Enter your choice: ");

            int mainChoice;
            while (true) {
                System.out.print("Enter your choice: ");
                if (scanner.hasNextInt()) {
                    mainChoice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid Action, Pick a number 1-5. ");
                    scanner.nextLine();
                }
            }

            switch (mainChoice) {
                case 1:
                    boolean exitServiceMenu = false;
                    while (!exitServiceMenu) {
                        System.out.println(" Vehicle List: ");
                        for (int i = 0; i < vehicles.length; i++) {
                            System.out.println((i + 1) + "." + vehicles[i]);
                        }
                        //Make you select which vehicle you would like to service
                        System.out.println("Choose a vehicle to Service (Enter number 1-3, or 0 to return to the main menu): ");

                        int vehicleChoice;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                vehicleChoice = scanner.nextInt() - 1;
                                if (vehicleChoice >= -1 && vehicleChoice < vehicles.length) {
                                    break;
                                } else {
                                    System.out.println("Invalid Action, Pick a number 1-3 or O. ");
                                }
                            } else {
                                System.out.println("Invalid Action, Pick a number. ");
                                scanner.next();
                            }
                        }
                        if (vehicleChoice == -1) {
                            exitServiceMenu = true;
                            continue;
                        }
                        Vehicle selectedVehicle = vehicles[vehicleChoice];

                        boolean exitService = false;
                        while (!exitService) {
                            // Services available
                            System.out.println("Choose Service to perform:");
                            System.out.println("1. Oil Change");
                            System.out.println("2. Brake Job");
                            System.out.println("3. Bill");
                            System.out.println("4. Return to Vehicle List ");
                            System.out.println("5. Main Menu");

                            int actionChoice;
                            while (true){
                                System.out.print("Enter your choice: ");
                                    if (scanner.hasNextInt()){
                                    actionChoice = scanner.nextInt();
                                    if (actionChoice >= 1 && actionChoice <=5) {
                                        break;
                            }else {
                                System.out.println("Invalid Action, Pick a number 1-5. ");
                                scanner.next();                       }
                            }
                        }
                        switch(actionChoice) {
                            case 1://Maintenance option for Oil change
                                M2.oilchange(selectedVehicle);
                                break;
                            case 2://Mechanic option for brake job
                                M1.brakejob(selectedVehicle);
                                break;
                            case 3://Billing option
                                Ron.Bills(selectedVehicle);
                                break;
                            case 4:
                                exitService = true;
                            case 5:
                                exitService = true;
                                exitServiceMenu = true;
                                break;
                                    default:
                          System.out.println("Invalid Action, Try again");
                          }
                            System.out.println(" Updated Vehicle Details: ");
                            // Prints out updated vehicle list
                            for (Vehicle vehicle : vehicles) {
                                System.out.println(vehicle);
                            }
                        }

                    }
                    break;
             case 2:
                  System.out.println(" ==Employee List== ");
                  // Prints out employee details
                  System.out.println(M1);
                  System.out.println(M2);
                  System.out.println(Ron);
                    break;
            case 3:
                System.out.println(" Current Shop Manager ");
                // prints out the manage()
                Ron.manage();
                    break;
            case 4:
                exitProgram = true;
                System.out.println(" Exit Program");

                    break;

                default:
                System.out.println(" Invalid Selection, Try again. ");
                }
            }
            scanner.close();
        }
}
