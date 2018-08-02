package View.MainPage;

import Model.ChartDataHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class PieChartDisplay extends StackPane implements Observer {

    // Chart used to show output to the user
    private PieChart chart;

    PieChartDisplay(ChartDataHolder backend) {
        backend.addObserver(this);
        start();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    /**
     * Create the UI elements that will display the probability pie chart to the user
     */
    private void start () {
        chart = new PieChart();
        chart.setTitle("CoCo Pull Probability");
        chart.setLabelsVisible(false);
        chart.setMaxWidth(300);

        this.getChildren().add(chart);
        this.setAlignment(Pos.CENTER_LEFT);
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
        chart.setData(pieChartData);
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
