//Bryan Montalvo Ramos
//COP 3330C-24217
//3/16/2025
//Basic class to set the attributes of the Driver
public class Driver {
    private String name;
    private int age;

    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //Getter for driver attributes
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    //Override method to set format for Driver information
    @Override   public String toString(){
        return name +"("+ age +" years old)";
    }
}