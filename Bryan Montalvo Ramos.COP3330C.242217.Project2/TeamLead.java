//Team lead class uses inherits the Name and department from Employee and Implements the Manager interface
public class TeamLead extends Employee implements Manager {
    public TeamLead(String name, String department) {
       super(name, department);//super class from employee

    }
    public void manage(){// method to announce Current Manager
        System.out.println( name + " from " + department + " is the current Shop Manager.");
    }

    @Override// Used to override method in Employee to set formating for TeamLead in the MechanicApp
    public String toString() {
            return "TeamLead [Name:" + name + ", Department:" + department + "]";
    }

}

