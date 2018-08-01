package Model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class ChartDataHolder extends Observable {

    private ArrayList<Double> stats;

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
        if (oneDrops != -1 && twoDrops != -1 && threeDrops != -1)
           stats = Statistics.compute(oneDrops, twoDrops, threeDrops);

        // Notify observers that a change has occurred
        setChanged();
        notifyObservers();
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

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
