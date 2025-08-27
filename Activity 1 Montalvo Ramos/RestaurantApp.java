
// Bryan Montalvo Ramos
//COP 3330C-24217
//1/14/2025
public class RestaurantApp {
    //Attributes
    private Wendy Wendy;
    private Outback Outback;
//Constructor
    public RestaurantApp( Wendy Wendy, Outback Outback){
        this.Wendy = Wendy;
        this.Outback= Outback;
    }
    //Overloaded Constructor
    public RestaurantApp(){
        this.Wendy= new Wendy();
        this.Outback= new Outback();
    }
    public Wendy getWendy() {
        return Wendy;
    }
    public Wendy setWendy(Wendy Wendy){
        this.Wendy = Wendy;
        return Wendy;
    }
    public Outback getOutback(){

        return Outback;
    }
    public Void OutbackSetOutback(Outback Outback){
        this.Outback = Outback;
        return null;
    }
    //Print Method- Defines the Details for both restaurants
    public void printDetails(){
        System.out.println("Wendy's Details:");
        System.out.println("Manager Name:" + Wendy.getManager_name());
        System.out.println("Employee Name:"+ Wendy.getEmployee_name());
        System.out.println("Total_Sales:" + Wendy.getTotal_sales());
        System.out.println("People_served:"+ Wendy.getPeople_served());
        System.out.println("Nuggets Sold:" + Wendy.getNuggets_sold());

        System.out.println("\n Outback's Details:");
        System.out.println("Manager Name:" + Outback.getManager_name());
        System.out.println("Employee Name:"+ Outback.getEmployee_name());
        System.out.println("Total_Sales:" + Outback.getTotal_sales());
        System.out.println("People_served:"+ Outback.getPeople_served());
    }
    //Main-Sets default parameters for each restaurant

        public void main(String[] args){
            Wendy = new Wendy("Mark","Miles",1000.0,100,10000);
            Outback= new Outback("Joey","Gerald",6000.0,80);
//Established the higher archy between the Restaurant and the restaurants
        RestaurantApp App = new RestaurantApp(Wendy, Outback);
        App.printDetails();
//Constructor to update parameters of both restaurant's values
        Wendy.updatePeople_served(255);
        Wendy.updateNuggets_sold(20000);
        Outback.updateManager_name("Miles");
       //Print Methods with original Values and Updated Details
        System.out.println("\nUpdated Details:");
        App.printDetails();


    }
}//End RestaurantApp
