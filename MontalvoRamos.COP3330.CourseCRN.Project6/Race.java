//Bryan Montalvo Ramos
//COP 3330C-24217
//3/16/2025
//Basic class to set Race attributes
public class Race {
    private String location;
    private int laps;
    private double bet;

    //Basic constructor for Race class
    public Race(String location, int laps, double bet) {
        this.location= location;
        this.laps= laps;
        this.bet = bet;

    }
    //Getters to get the Racing attributes
    public String getLocation() {
        return location;

    }
    public void setLocation(String location) {
        this.location = location;

    }
    public int getLaps() {
        return laps;

    }
    public double getBet() {
        return bet;
    }
    //Override to set format of Race details
    @Override
    public String toString() {
        return "Race at "+location+" ("+laps+" laps, $ "+bet+ "Win)";
    }
}
