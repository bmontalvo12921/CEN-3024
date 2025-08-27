//Bryan Montalvo Ramos
//COP 3330C-24217
//3/16/2025
// This class is set up to create the different attributes for the vehicles
public class Car {
    private String make;
    private String model;
    private int year;
    private int horsepower;

    //Constructor for the vehicle
    public Car(String make, String model, int year, int horsepower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
    }

    //Getters in order to acquire Model,Make,Year, and HorsePower
    public String getModel() {
        return model;
    }
    public String getMake() {
        return make;
    }
    public int getYear(){
        return year;
    }
    public int getHorsepower(){
        return horsepower;
    }

    //Override method to set the format of the string returned when adding values in.
    @Override
    public String toString() {
            return "Car [make=" + make + ", model=" + model + ", year=" + year + ", horsepower=" + horsepower + "]";
    }
}
