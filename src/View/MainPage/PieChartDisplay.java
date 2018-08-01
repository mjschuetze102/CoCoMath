package View.MainPage;

import Model.ChartDataHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class PieChartDisplay extends PieChart implements Observer {

    PieChartDisplay(ChartDataHolder backend) {
        backend.addObserver(this);
        start();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    private void start () {
        this.setTitle("CoCo Pull Probability");
        this.setLabelsVisible(false);
    }

    /**
     * Receives data from the backend and updates the display
     * @param o- the object that was changed
     * @param arg- varies based on object
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ChartDataHolder)
            displayStatistics(((ChartDataHolder) o).getStats());
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /**
     * Displays the output to the user
     * @param stats- statistics calculated from user input
     */
    private void displayStatistics(ArrayList<Double> stats) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("P[0]", stats.get(2)),
                new PieChart.Data("P[1]", stats.get(3)),
                new PieChart.Data("P[2]", stats.get(4))
        );
        this.setData(pieChartData);
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
