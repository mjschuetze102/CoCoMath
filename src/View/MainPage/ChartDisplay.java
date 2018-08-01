package View.MainPage;

import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.chart.PieChart;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class ChartDisplay extends Scene {

    private ArrayList<Double> stats;

    public ChartDisplay(Parent root, double width, double height, ArrayList<Double> stats) {
        super(root, width, height);
        this.stats = stats;
        display();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    private void display() {
        ArrayList<Pair<String, Double>> chartData = new ArrayList<>(Arrays.asList(
                new Pair<>("P[0]", stats.get(2)),
                new Pair<>("P[1]", stats.get(3)),
                new Pair<>("P[2]", stats.get(4))
        ));

        PieChart chart = createPieChart(chartData, "Collected Company Pull Probability");

        ((Group) this.getRoot()).getChildren().add(chart);
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    private PieChart createPieChart(ArrayList<Pair<String, Double>> data, String title) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Pair<String, Double> pair: data) {
            pieChartData.add(new PieChart.Data(pair.getKey(), pair.getValue()));
        }

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(title);

        return chart;
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
