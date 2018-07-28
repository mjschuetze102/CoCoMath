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

        System.out.println("Converted Mana Cost: " + stats.get(0));
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
