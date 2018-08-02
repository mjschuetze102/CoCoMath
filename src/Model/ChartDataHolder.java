package Model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class ChartDataHolder extends Observable {

    // Variable to hold the statistics for the UI to use
    private ArrayList<Double> stats;

    // Variable to hold values for the line charts to use
    private ArrayList<ArrayList<Double>> cmcSpecificStats;

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    /**
     * Calls the statistics class to compute statistics with the given inputs
     * @param oneDrops- number of one drops in the deck
     * @param twoDrops- number of two drops in the deck
     * @param threeDrops- number of three drops in the deck
     */
    public void computeStatistics(int oneDrops, int twoDrops, int threeDrops) {
        if (oneDrops != -1 && twoDrops != -1 && threeDrops != -1) {
            // Initialize the CMC Specific Stats variable
            cmcSpecificStats = new ArrayList<>();

            // Store drop counts in an easily callable way from a loop
            int[] dropCount = new int[] {oneDrops, twoDrops, threeDrops};

            // Compute the CMC value being pulled from CoCo for changes in each CMC value input
            for (int cmc = 0; cmc < 3; cmc++) {
                // Initialize the ArrayList for the specific CMC value
                cmcSpecificStats.add(new ArrayList<>());

                // Add in the offset that will be used for X axis
                cmcSpecificStats.get(cmc).add((double) dropCount[cmc]);

                // Compute stats for each input +- 5
                for (int index = dropCount[cmc] - 5; index < dropCount[cmc] + 6; index++) {
                    // Create a copy of the original drop counts so it's not edited
                    int[] tempArray = new int[3];
                    System.arraycopy(dropCount, 0, tempArray, 0, 3);

                    // Change the value of the chosen CMC value input
                    tempArray[cmc] = index;

                    // Add the statistic to the list
                    cmcSpecificStats.get(cmc).add(Statistics.compute(tempArray[0], tempArray[1], tempArray[2]).get(5));
                }
            }

            // Compute the stats for UI output
            stats = Statistics.compute(oneDrops, twoDrops, threeDrops);

            // Notify observers that a change has occurred
            setChanged();
            notifyObservers();
        }
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /**
     * Provides the statistics data
     * @return ArrayList with the statistics data
     */
    public ArrayList<Double> getStats() {
        return this.stats;
    }

    /**
     * Provides the statistics data for the specified cmc value
     * @param cmc- the CMC for the input that's being changed
     * @return ArrayList of the values that would appear if the amount of drops for the chosen CMC was changed
     */
    public ArrayList<Double> getCMCSpecificStats(int cmc) {
        return this.cmcSpecificStats.get(cmc);
    }

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
