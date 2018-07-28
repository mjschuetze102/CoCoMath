import java.util.ArrayList;

/**
 * Written by Michael Schuetze on 7/28/2018.
 */
public class Statistics {

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    public static ArrayList<Double> compute(int one, int two, int three) {
        ArrayList<Double> stats = new ArrayList<>();

        double convertedManaCost = (one + 2 * two + 3 * three) / (one + two + three);
        stats.add(convertedManaCost);

        double chanceDrawOne = one / 60.0;
        double chanceDrawTwo = two / 60.0;
        double chanceDrawThree = three / 60.0;
        double chanceDrawZero = 1 - (chanceDrawOne + chanceDrawTwo + chanceDrawThree);

        return stats;
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
