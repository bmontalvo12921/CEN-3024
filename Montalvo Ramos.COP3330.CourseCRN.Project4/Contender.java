//Bryan Montalvo Ramos
//Course: COP 3330C - 24217
//2/16/2025
//Contender defines the values for each competitor and sets up the way the contest is going to run
public class Contender implements Runnable {
    private String name;
    private int meatPerTurn;
    private int totalMeatEaten;
    private int maxRest;

    private static volatile boolean winner = false;
    private Water water;
//constructors with default values
    public Contender(String name, int meatPerTurn, int maxRest, Water water) {
        this.name = name;
        this.meatPerTurn = meatPerTurn;
        this.totalMeatEaten = 0;
        this.maxRest = maxRest;
        this.water = water;
    }
        //sets the way the contest is going to be run
    //
    @Override
    public void run() {
        while (!winner) { // Keep running until a winner is declared
            System.out.println(name + " is still in battle.. Current total: " + totalMeatEaten);

            if (winner) return;
            try {
                int restTime = (int) (Math.random() * maxRest);
                System.out.println(name + " will rest for " + restTime + "ms...");//Random rest interval to show real world variables
                Thread.sleep(restTime); // Simulate rest time
                //redundancy to check if there is a winner
                if (winner) return;
                //sets meat eaten by turn and allows to accumulate throughout the contest
                int meatThisTurn = Math.min(meatPerTurn, 200 - totalMeatEaten);
                totalMeatEaten += meatThisTurn;//accumulates the count as it progresses
                System.out.println(name + " has eaten " + totalMeatEaten + " pieces of meat.");
                //uses the water class and ensure the contestants have a water break
                water.drink(name); // Call drink method from Water class, only one contestant can drink at a time

                if (winner) return;
                //ensure that both threads are being run together
                synchronized (Contender.class) { // checks for winner
                    if (!winner && totalMeatEaten >= 200) {
                        winner = true;
                        System.out.println("\n ---- " + name + " has won! "+"-----\n ");
                        return;
                    }
                }
            } catch (InterruptedException e) {// set up to catch any errors
                Thread.currentThread().interrupt();
                System.out.println(name + " was interrupted.");
            }
        }
    }

    public static boolean isWinnerDeclared() {
        return winner;
    }// ensure that the winner is declared and announced
}
