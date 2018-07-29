import java.util.ArrayList;
import java.util.Scanner;

/**
 * Written by Michael Schuetze on 7/28/2018.
 */
public class PTUI {

    int oneDrops;
    int twoDrops;
    int threeDrops;

    public PTUI() {
        receiveData();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    public void computeStatistics() {
        ArrayList<Double> stats = Statistics.compute(oneDrops, twoDrops, threeDrops);

        System.out.println("Number of Fetchable Creatures: " + stats.get(0));
        System.out.println("Average CMC for Creatures: " + stats.get(1));
        System.out.println("P[0] Creatures: " + stats.get(2));
        System.out.println("P[1] Creatures: " + stats.get(3));
        System.out.println("P[2] Creatures: " + stats.get(4));
        System.out.println("Average CMC from CoCo: " + stats.get(5));
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /**
     * Receives user input and stores the values so they made be used later
     */
    private void receiveData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount of 1 drops: ");
        oneDrops = scanner.nextInt();
        System.out.println("Enter the amount of 2 drops: ");
        twoDrops = scanner.nextInt();
        System.out.println("Enter the amount of 3 drops: ");
        threeDrops = scanner.nextInt();
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////

    public static void main(String[] args) {
        PTUI ui = new PTUI();
        ui.computeStatistics();
    }
}
