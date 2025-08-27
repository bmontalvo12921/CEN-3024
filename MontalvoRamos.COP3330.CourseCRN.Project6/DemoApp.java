//Bryan Montalvo Ramos
//COP 3330C-24217
//3/16/2025
//Demonstrate the use of all classes and Generic containers to accomplish several functions.
//This app is set up to be user driven
import java.util.Comparator;
import java.util.Scanner;

public class DemoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       //Generic containers containing Cars, Drivers and Race information
        Container<Car> carContainer = new Container<>();
        carContainer.add(new Car("Nissan", "Skyline GTR",1999,500));
        carContainer.add(new Car("Dodge", "Challenger",1970,900));
        carContainer.add(new Car("Nissan", "240SX",1997,400));

        //Driver Container
        Container<Driver> driverContainer = new Container<>();
        driverContainer.add(new Driver("Dominic Toretto", 30));
        driverContainer.add(new Driver("Brian O'Conner", 25));
        driverContainer.add(new Driver("Letty Ortiz", 20));

        //Race Container- Contains the full information of the Race
        Container<Race> raceContainer = new Container<>();
        raceContainer.add(new Race("Los Angeles", 5, 50000));
        raceContainer.add(new Race("Tokyo Drift", 10, 100000));
        raceContainer.add(new Race("Rio Heist", 3, 75000));

        //Sets up initial menu to choose what kind of function to utilized
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add a Car");
            System.out.println("2. Remove a Car");
            System.out.println("3. Add a Driver");
            System.out.println("4. Remove a Driver");
            System.out.println("5. Add a Race");
            System.out.println("6. Remove a Race");
            System.out.println("7. View All Data");
            System.out.println("8. Sort List");
            System.out.println("9. Search");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            //broken down by different cases to ensure everything is working properly
            switch (choice) {
                case 1:// Case 1,2 deals with adding and removing cars from the Car container, and cathces exceptions
                    System.out.print("Enter Car Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Car Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Car Horsepower: ");
                    int hp = scanner.nextInt();
                    carContainer.add(new Car(make, model, year, hp));
                    System.out.println("Car added successfully!");
                    break;

                case 2:
                    System.out.println("Available Cars:");
                    carContainer.printAll();
                    System.out.print("Enter Car Make to remove: ");
                    String removeMake = scanner.nextLine();
                    Car carToRemove = null;
                    for (Car car : carContainer.getItems()) {
                        if (car.getMake().equalsIgnoreCase(removeMake)) {
                            carToRemove = car;
                            break;
                        }
                    }
                    if (carToRemove != null) {
                        carContainer.remove(carToRemove);
                        System.out.println("Car removed successfully!");
                    } else {
                        System.out.println("Car not found.");
                    }
                    break;
                    //Case 3,4 deals with adding and removing drivers and catches exceptions
                case 3:
                    System.out.print("Enter Driver Name: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Enter Driver Experience Level: ");
                    int experience = scanner.nextInt();
                    driverContainer.add(new Driver(driverName, experience));
                    System.out.println("Driver added successfully!");
                    break;

                case 4:
                    System.out.println("Available Drivers:");
                    driverContainer.printAll();
                    System.out.print("Enter Driver Name to remove: ");
                    String removeDriver = scanner.nextLine();
                    Driver driverToRemove = null;
                    for (Driver driver : driverContainer.getItems()) {
                        if (driver.getName().equalsIgnoreCase(removeDriver)) {
                            driverToRemove = driver;
                            break;
                        }
                    }
                    if (driverToRemove != null) {
                        driverContainer.remove(driverToRemove);
                        System.out.println("Driver removed successfully!");
                    } else {
                        System.out.println("Driver not found.");
                    }
                    break;

                case 5:// Case 5,6 deals with adding and removing locations, and catches exceptions
                    System.out.print("Enter Race Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Number of Laps: ");
                    int laps = scanner.nextInt();
                    System.out.print("Enter Bet Amount: ");
                    double bet = scanner.nextDouble();
                    raceContainer.add(new Race(location, laps, bet));
                    System.out.println("Race added successfully!");
                    break;

                case 6:
                    System.out.println("Available Races:");
                    raceContainer.printAll();
                    System.out.print("Enter Race Location to remove: ");
                    String removeRace = scanner.nextLine();
                    Race raceToRemove = null;
                    for (Race race : raceContainer.getItems()) {
                        if (race.getLocation().equalsIgnoreCase(removeRace)) {
                            raceToRemove = race;
                            break;
                        }
                    }
                    if (raceToRemove != null) {
                        raceContainer.remove(raceToRemove);
                        System.out.println("Race removed successfully!");
                    } else {
                        System.out.println("Race not found.");
                    }
                    break;

                case 7://Case 7 is the full print out of all the containers including any changes made.
                    System.out.println("\n=== Cars ===");
                    carContainer.printAll();
                    System.out.println("\n=== Drivers ===");
                    driverContainer.printAll();
                    System.out.println("\n=== Races ===");
                    raceContainer.printAll();
                    break;
                case 8://Case 8 is a simple sort using Comparator
                    System.out.println("\nCars before sorting:");
                    carContainer.printAll();
                    // Comparator Sorting by Horsepower
                    carContainer.sort(Comparator.comparingInt(Car::getHorsepower));
                    System.out.println("\nCars after sorting by HP:");
                    carContainer.printAll();
                    //Comparator Sorting by Year
                    carContainer.sort(Comparator.comparingInt(Car::getYear));
                    System.out.println("\nCars after sorting by year:");
                    carContainer.printAll();
                    carContainer.sort(Comparator.comparingInt(Car::getYear).reversed());
                    System.out.println("\nCars after sorting by year descending:");
                    carContainer.printAll();

                    //Comparator Sorting by Make
                    carContainer.sort(Comparator.comparing(Car::getMake));
                    System.out.println("\nCars after sorting by make:");
                    carContainer.printAll();
                    break;

                case 9://Case 9 is a Index Search using the Search class
                    System.out.println("Search Driver by Name");
                    System.out.print("Enter Driver Name to search: ");
                        String searchName = scanner.nextLine();
                        int index= -1;
                        for (Driver driver : driverContainer.getItems()) {
                            if (driver.getName().equalsIgnoreCase(searchName)) {
                                index = driverContainer.findIndex(driver);
                                break;
                            }
                        }
                        System.out.println(index != -1 ? searchName + " found at index: " + index : "Driver not found.");
                    break;

                case 10://Case 10 closes the program
                    System.out.println("Exiting program...");
                    break;

                default:// set to catch any invalid choices in the main menu
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}