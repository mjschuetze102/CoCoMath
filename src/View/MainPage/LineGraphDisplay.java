package View.MainPage;

import Model.ChartDataHolder;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class LineGraphDisplay extends StackPane implements Observer {

    // Chart used to show output to the user
    private LineChart<Number, Number> chart;

    // CMC this graph will represent
    private int cmc;

    LineGraphDisplay(ChartDataHolder backend, int cmc) {
        backend.addObserver(this);
        this.cmc = cmc;
        start();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    /**
     * Create the UI elements that will display the line chart to the user
     */
    private void start () {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setForceZeroInRange(false);
        yAxis.setForceZeroInRange(false);
        xAxis.setAnimated(false);
        yAxis.setAnimated(false);

        xAxis.setLabel("Number of " + cmc + " Drops");
        xAxis.setMinorTickVisible(false);

        chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Changes in " + cmc + " Drops");
        chart.setLegendSide(Side.LEFT);
        chart.setAnimated(false);

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
            displayStatistics(((ChartDataHolder) o).getCMCSpecificStats(cmc - 1));
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
        chart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        series.setName("CMC");

        double offset = stats.get(0);

        for (int index = 1; index < stats.size(); index++) {
            series.getData().add(new XYChart.Data(index + offset, stats.get(index)));
        }

        chart.getData().add(series);
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
