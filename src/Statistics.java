import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Written by Michael Schuetze on 7/28/2018.
 */
public class Statistics {

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    public static ArrayList<Double> compute(int one, int two, int three) {
        // Create the Array that will hold all of the statistics
        ArrayList<Double> stats = new ArrayList<>();

        // Compute the Average Converted Mana Cost of the cards
        double convertedManaCost = (one + 2 * two + 3 * three) / (one + two + three);
        stats.add(convertedManaCost);

        // Compute the probability of drawing a card with the specified cost
        double chanceDrawOne = one / 60.0;
        double chanceDrawTwo = two / 60.0;
        double chanceDrawThree = three / 60.0;
        double chanceDrawZero = 1 - (chanceDrawOne + chanceDrawTwo + chanceDrawThree);

        // Add the probabilities to an array to keep them organized and easy to call from within loops
        double[] drawChances = new double[] {chanceDrawZero, chanceDrawOne, chanceDrawTwo, chanceDrawThree};
//        03, 02, 01, 00,
//        13, 12, 11,
//        23, 22,
//        33,
//
//00 = chanceDrawZero + chanceDrawZero + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;
//01 = chanceDrawZero + chanceDrawOne + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;
//02 = chanceDrawZero + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;
//03 = chanceDrawZero + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;
//
//11 = chanceDrawOne + chanceDrawOne + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 4 + chanceDrawZero ^ 0;
//     chanceDrawOne + chanceDrawOne + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 3 + chanceDrawZero ^ 1;
//     chanceDrawOne + chanceDrawOne + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 2 + chanceDrawZero ^ 2;
//     chanceDrawOne + chanceDrawOne + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 1 + chanceDrawZero ^ 3;
//     chanceDrawOne + chanceDrawOne + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;
//
//
//22 = chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 4 + chanceDrawOne ^ 0 + chanceDrawZero ^ 0;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 3 + chanceDrawOne ^ 1 + chanceDrawZero ^ 0;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 3 + chanceDrawOne ^ 0 + chanceDrawZero ^ 1;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 2 + chanceDrawZero ^ 0;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 1 + chanceDrawZero ^ 1;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 0 + chanceDrawZero ^ 2;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 3 + chanceDrawZero ^ 0;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 2 + chanceDrawZero ^ 1;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 1 + chanceDrawZero ^ 2;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 0 + chanceDrawZero ^ 3;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 4 + chanceDrawZero ^ 0;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 3 + chanceDrawZero ^ 1;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 2 + chanceDrawZero ^ 2;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 1 + chanceDrawZero ^ 3;
//     chanceDrawTwo + chanceDrawTwo + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;
//
//
//
//33 = chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 4 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 3 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 0 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 3 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 1 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 3 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 2 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 0 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 2 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 1 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 2 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 0 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 2 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 2 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 2 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 1 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 2 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 2;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 3 + chanceDrawOne ^ 0 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 1 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 0 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 2 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 1 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 0 + chanceDrawZero ^ 2;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 3 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 2 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 1 + chanceDrawZero ^ 2;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 1 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 3;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 4 + chanceDrawOne ^ 0 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 3 + chanceDrawOne ^ 1 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 3 + chanceDrawOne ^ 0 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 2 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 1 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 2 + chanceDrawOne ^ 0 + chanceDrawZero ^ 2;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 3 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 2 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 1 + chanceDrawZero ^ 2;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 1 + chanceDrawOne ^ 0 + chanceDrawZero ^ 3;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 4 + chanceDrawZero ^ 0;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 3 + chanceDrawZero ^ 1;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 2 + chanceDrawZero ^ 2;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 1 + chanceDrawZero ^ 3;
//     chanceDrawThree + chanceDrawThree + chanceDrawThree ^ 0 + chanceDrawTwo ^ 0 + chanceDrawOne ^ 0 + chanceDrawZero ^ 4;

        // Create the 2D array that will hold the draw probabilities for drawing the provided mana cost
        double[][] drawProbability = new double[4][4];

        // Go through all the possibilities of highest value from draw
        // i.e. 33, 32, 31, 30, 22, 21, 20, 11, 10, 00
        for (int cardOne = 3; cardOne >= 0; cardOne--) {
            for (int cardTwo = 3; cardTwo >= 0; cardTwo--) {
                // Initialize the probability for that combo
                drawProbability[cardOne][cardTwo] = 0;

                // Continue to next probability if it's already been counted
                // i.e. 32 and 23 are the same
                if (cardTwo > cardOne)
                    continue;

                // Create an array that will store the powers of each probability
                int[] power = new int[4]; // {0, 0, 0, 0}
                power[cardTwo] = 4;

                // Loop through all the possible combinations of powers
                // i.e. 4000, 3100, 3010, 3001, 2200, 2110, 2101, 2020, 2011, etc...
                // Note. The above is not the depiction of the array, rather the powers for the probability
                // 4000 would represent 3 ^ 4 + 2 ^ 0 + 1 ^ 0 + 1 ^ 0 or power = [0, 0, 0, 4]
                while (true) {
                    double probability = drawChances[cardOne] * drawChances[cardTwo]
                            * Math.pow(drawChances[3], power[3]) * Math.pow(drawChances[2], power[2])
                            * Math.pow(drawChances[1], power[1]) * Math.pow(drawChances[0], power[0]);

                    // Get the count of the number of cards for each converted cost
                    int[] temp = new int[4];
                    System.arraycopy(power, 0, temp, 0, 4);
                    temp[cardOne] += 1;
                    temp[cardTwo] += 1;

                    // Figure out how many times the same combination could occur
                    int multiplier = 1;
                    int alreadyCounted = 0;
                    for (int value : temp) {
                        multiplier *= nCr(6 - alreadyCounted, value);
                        alreadyCounted += value;
                    }

                    // Add the probability of this combination to the others
                    drawProbability[cardOne][cardTwo] += multiplier * probability;

                    // Break out of loop once all the other drawn cards do not count
                    if (power[0] == 4)
                        break;
//                    System.out.println(drawChances[cardOne]);
//                    System.out.println(drawChances[cardTwo]);
//                    System.out.println(Math.pow(drawChances[3], power[3]));
//                    System.out.println(Math.pow(drawChances[2], power[2]));
//                    System.out.println(Math.pow(drawChances[1], power[1]));
//                    System.out.println(Math.pow(drawChances[0], power[0]));
//                    System.out.println("Equals: " + drawProbability[cardOne][cardTwo]);

                    // Using depiction of 1030, it would be the 3
                    // Which would be the left most in the array [0, 3, 0, 1]
                    // This also does not consider power[0]
                    int rightMostNonZero = findNonZeroIndex(power);

                    // Collect all the values from the powers above the right-most
                    temp = new int[4];
                    System.arraycopy(power, rightMostNonZero, temp, rightMostNonZero, 4 - rightMostNonZero);
                    System.arraycopy(temp, 0, power, 0, 4);

                    // Remove 1 from the count of the right most and provide values for the next iteration
                    power[rightMostNonZero] -= 1;
                    power[rightMostNonZero - 1] = 4 - IntStream.of(power).sum();
                }
            }
        }

        return stats;
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /**
     * Finds the index of the first nonzero value
     * @param values- Array to search through for nonzero value
     * @return index of the first non zero value in the array
     */
    private static int findNonZeroIndex(int[] values) {
        for (int index = 1; index < values.length; index++) {
            if (values[index] != 0)
                return index;
        }

        return 0;
    }

    /**
     * The number of different, unordered combinations of r objects from a set of n objects.
     * @param n- number of objects to choose from
     * @param r- number of objects to choose
     * @return the number of combinations from choosing r objects from n
     */
    private static int nCr(int n, int r) {
        if (r == n || r == 0)
            return 1;

        if (n < r || n == 0)
            return 0;

        if (r == 1)
            return n;

        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    /**
     * Function that finds the factorial of a number
     * @param num- number to find the factorial of
     * @return the factorial of a number
     */
    private static int factorial(int num) {
        int result = 1;
        for (int x = 2; x <= num; x++) {
            result *= x;
        }

        return result;
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
