// Employee class is the parent Class for TeamLead, and implements the Worker interface
public class Employee implements  Worker{
    protected String name;
    protected String department;

    //Constructor to set up Employee default attributes
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    //Setter's and Getter's
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
    //method to print employee details
    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
    //overriding method from Worker interface
    @Override
    public void oilchange(Vehicle vehicle) {
        System.out.println("Employee " + name + " is performing an oil change on a " + vehicle.getMake()+ vehicle.getModel());
        int newMileage = vehicle.getmileage() + 3000;
        vehicle.setMileage(newMileage);
        System.out.println("Next Oil change at:" + newMileage+" Miles");
    }
    //Overriding methods in Worker interface
    @Override
    public void brakejob(Vehicle vehicle) {
        System.out.println("Employee " + name + " is performing a brake job on a " + vehicle.getMake()+ vehicle.getModel());
        int newMileage = vehicle.getmileage() + 20000;
        vehicle.setMileage(newMileage);
        System.out.println("Next Brake Job at:"+ newMileage +" Miles");
    }
    //method to set formating for employee
    @Override
    public String toString() {
        return "Employee [Name: " + name + ", Department: " + department + "]";
    }
    //Override methods in Worker interface
    @Override
    public void Bills(Vehicle vehicle) {
        double billamount = 0.0;

        System.out.println(name + "is calculating the bill amount on "+vehicle.getyear()+vehicle.getMake()+vehicle.getModel());

        if (vehicle.getType().equals("Car")) {
            billamount = 60.00;
            System.out.println("Oil Change - $60.00");
        }
        if(vehicle.getType().equals("Motorcycle")) {
            billamount = 120.00;
            System.out.println("Brake Job - $120.00");
        }
        System.out.printf("Total Bill: $%.2f%n ", billamount);
    }

}