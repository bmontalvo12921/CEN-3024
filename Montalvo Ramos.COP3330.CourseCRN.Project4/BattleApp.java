//Bryan Montalvo Ramos
//Course: COP 3330C - 24217
//2/16/2025
//Simulate a meat eating contest between T-Rex and Velociraptor using threads
public class BattleApp {
    public static void main(String[] args) {
        Water sharedWater = new Water();
        //constructors with different attributes
        Contender trex= new Contender(" T-Rex ", 15, 500, sharedWater);
        Contender raptor = new Contender(" Velociraptor ", 10, 300, sharedWater);
        //Threads defined
        Thread t1 = new Thread(trex);
        Thread t2 = new Thread(raptor);
        t1.start();
        t2.start();
        //allows for a break in the program or sleep
        while (!Contender.isWinnerDeclared()) {
            try {
                Thread.sleep(100); // Delay to prevent CPU overload
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        //print out for winner
        System.out.println("Winner declared. Battle won!");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(" Main Thread interrupted ");
        }
        //announces the Battle has concluded
        System.out.println("Battle has concluded.");
    }
}
