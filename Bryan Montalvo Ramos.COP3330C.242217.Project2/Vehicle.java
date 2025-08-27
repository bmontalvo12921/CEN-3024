public class Vehicle implements Vehicleclass{
    //protected attributes that is used to show the detail of the Vehicle
    protected String type;
     protected String make;
     protected String model;
     protected Integer year;
     protected Integer mileage;
    //constructor to set default values
     public Vehicle(String type, String make, String model , Integer year, Integer mileage) {
    this.type = type;
    this.make=make;
    this.model=model;
    this.year = year;
     this.mileage=mileage;
     }
    //Getters and Setters
    public String getType(){
     return type;
    }
    public String getMake(){
     return make;
    }
    public String getModel(){
     return model;
    }
    public Integer getyear(){
     return year;
    }
    public Integer getmileage(){
     return mileage;
    }
    public void setType(String Type){
     this.type = Type;
    }
    public void setMake(String Make){
     this.make = Make;
    }
    public void setModel(String Model){
     this.model = Model;
    }
    public void setyear(Integer year){
     this.year = year;
    }
    public void setMileage(Integer mileage){
     this.mileage = mileage;
    }
    public void updatemileage(int Newmileage){
        System.out.println("UpdateMileage:"+Newmileage);
        this.mileage = Newmileage;


    }
    //Override that implements VehicleClas attributes  and prints vehicle details
    @Override
         public void Car() {
        System.out.println("Car: " + make + " " + model + " " + year + "Mileage: " + mileage);
    }

             // Override Motorcycle() method
     @Override
       public void Motorcycle() {
       System.out.println("Motorcycle: " + make + " " + model + " " + year + " Mileage: " + mileage);
     }

            // Override toString()
     @Override
      public String toString() {
       return "Vehicle [Type: " + type + ", Make: " + make + ", Model: " + model + ", Year: " + year + ", Mileage: " + mileage + "]";
       }
}