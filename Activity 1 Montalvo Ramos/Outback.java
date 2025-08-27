public class Outback {
    //Attributes
    private String Manager_name;
    private String Employee_name;
    private Double Total_sales;
    private Integer People_served;
    //Constructors
    public Outback(String Manager_name, String Employee_name, Double Total_sales,Integer People_served){
        this.Manager_name = Manager_name;
        this.Employee_name = Employee_name;
        this.Total_sales = Total_sales;
        this.People_served = People_served;
    }
    //Overloaded Constructor
    public Outback(){
        this.Manager_name = "Joey";
        this.Employee_name= "Gerald";
        this.Total_sales = 6000.00;
        this.People_served = 80;
    }
    //Getters and Setters
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
    public Integer setPeople_served( Integer People_served){
        this.People_served = People_served;
        return People_served;
    }
    // Instance Method
    //Update Manger and People Served
    public Integer updatePeople_served(Integer People_served){
        this.People_served = People_served;
        return People_served;
    }
    public String updateManager_name(String Manager_name){
        this.Manager_name = Manager_name; return Manager_name;}

//Main
    public static void main(String[] args){
        Outback Outback = new Outback();
        // Print Methods
        System.out.println("Store 1:");
        System.out.println("Manager Name:"+ Outback.getManager_name());
        System.out.println("Employee Name:" + Outback.getEmployee_name());
        System.out.println("Total sales:" + Outback.getTotal_sales());
        System.out.println("People Served:" + Outback.getPeople_served());

    }

}// End Outback Class
