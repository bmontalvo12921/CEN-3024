public class Wendy{
    //Attributes
    private String Manager_name;
    private String Employee_name;
    private Double Total_sales;
    private Integer People_served;
    private Integer Nuggets_sold;
    //Constructor
     public Wendy(String Manager_name, String Employee_name, Double Total_sales,Integer People_served, Integer Nuggets_sold) {
        this.Manager_name = Manager_name;
         this.Employee_name = Employee_name;
         this.Total_sales = Total_sales;
        this.People_served = People_served;
        this.Nuggets_sold = Nuggets_sold;
     }
     //Overloaded Constructor
   public Wendy(){
        this.Manager_name = "Monty";
         this.Employee_name= "Mark";
        this.Total_sales = 1000.00;
         this.People_served = 100;
         this.Nuggets_sold = 10000;
     }
     //Getter and Setters (Instance Method)
    public String getManager_name(){

         return  this.Manager_name;
     }
    public String setManager_name(String Manger_name){
         this.Manager_name = Manger_name;
        return Manger_name;
    }
    public String getEmployee_name(){
        return  this.Employee_name;
        }
    public String setEmployee_name(String Employee_name){
         this.Employee_name = Employee_name;
     return Employee_name;}
    public Double getTotal_sales(){

         return this.Total_sales;
         }
    public Double setTotal_sale(Double Total_sales){
            this.Total_sales = Total_sales;
     return Total_sales;}
    public Integer getPeople_served(){

         return this.People_served;
        }
    public Integer setPeople_served( Integer People_served) {
        this.People_served = People_served;
        return People_served;
    }
     public Integer getNuggets_sold() {
         return this.Nuggets_sold;
     }
     public Integer setNuggets_sold(Integer Nuggets_sold){
         this.Nuggets_sold = Nuggets_sold;
         return Nuggets_sold;
        }
    public Integer updatePeople_served(Integer People_served) {
        this.People_served = People_served;
        return People_served;
    }
    public Integer updateNuggets_sold(Integer Nuggets_sold){
       this.Nuggets_sold = Nuggets_sold;
         return Nuggets_sold;
    }
    public String updateManager_name(String Manager_name){
    this.Manager_name = Manager_name;
    return Manager_name;}
    //Main
    public static void main(String[] args){
    Wendy Wendy= new Wendy();
    //Print Method
    System.out.println("Store:");
    System.out.println("Manager Name:"+ Wendy.getManager_name());
    System.out.println("Employee Name:" + Wendy.getEmployee_name());
    System.out.println("Total sales:" + Wendy.getTotal_sales());
    System.out.println("People Served:" + Wendy.getPeople_served());
    System.out.println("Nuggets Sold:" + Wendy.getNuggets_sold());
     }
}//End Wendy class