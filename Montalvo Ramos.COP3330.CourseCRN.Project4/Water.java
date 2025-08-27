//Bryan Montalvo Ramos
//Course: COP 3330C - 24217
//2/16/2025
public class Water {
    public synchronized void drink(String name) {
        try {
            if (Contender.isWinnerDeclared()) return; // Exit early if a winner exists

            System.out.println(name + " is drinking water.");

            int sleepTime = name.equals(" T-Rex ") ? 1500 : 1000;

            for (int i = 0; i < sleepTime / 100; i++) { // Check every 100ms to exit early
                if (Contender.isWinnerDeclared()) return;
                Thread.sleep(100);
            }

            if (Contender.isWinnerDeclared()) return;
            System.out.println(name + " is done drinking water.");
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted while drinking water.");
        }
    }
}