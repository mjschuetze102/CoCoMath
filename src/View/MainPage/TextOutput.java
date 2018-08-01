package View.MainPage;

import Model.ChartDataHolder;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class TextOutput extends GridPane implements Observer {

    // Variables to store output to the user
    private Label fieldNumFetchable;
    private Label fieldCreatureAvgCMC;
    private Label fieldProbZero;
    private Label fieldProbOne;
    private Label fieldProbTwo;
    private Label fieldCoCoAvgCMC;

    TextOutput(ChartDataHolder backend) {
        backend.addObserver(this);
        start();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    /**
     * Create the UI elements that display text statistics to the user
     */
    private void start() {
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setHgap(15);

        Label labelNumFetchable = new Label("Number of Fetchable Creatures:");
        labelNumFetchable.setTooltip(new Tooltip(
                "Number of creatures in the\n" +
                        "deck that could be pulled by\n" +
                        "Collected Company"
        ));
        fieldNumFetchable = new Label();
        GridPane.setConstraints(labelNumFetchable, 0, 0);
        GridPane.setConstraints(fieldNumFetchable, 1, 0);

        Label labelCreatureAvgCMC = new Label("Average CMC for Creatures:");
        labelCreatureAvgCMC.setTooltip(new Tooltip(
                "Average Converted Mana Cost\n" +
                        "of the creatures in your deck\n" +
                        "that can be pulled by \n" +
                        "Collected Company"
        ));
        fieldCreatureAvgCMC = new Label();
        GridPane.setConstraints(labelCreatureAvgCMC, 0, 1);
        GridPane.setConstraints(fieldCreatureAvgCMC, 1, 1);

        Label labelProbZero = new Label("P[0] Creatures:");
        labelProbZero.setTooltip(new Tooltip(
                "Probability of pulling\n" +
                        "0 creatures from\n" +
                        "Collected Company"
        ));
        fieldProbZero = new Label();
        GridPane.setConstraints(labelProbZero, 0, 2);
        GridPane.setConstraints(fieldProbZero, 1, 2);

        Label labelProbOne = new Label("P[1] Creatures:");
        labelProbOne.setTooltip(new Tooltip(
                "Probability of pulling\n" +
                        "1 creature from\n" +
                        "Collected Company"
        ));
        fieldProbOne = new Label();
        GridPane.setConstraints(labelProbOne, 0, 3);
        GridPane.setConstraints(fieldProbOne, 1, 3);

        Label labelProbTwo = new Label("P[2] Creatures:");
        labelProbTwo.setTooltip(new Tooltip(
                "Probability of pulling\n" +
                        "2 creatures from\n" +
                        "Collected Company"
        ));
        fieldProbTwo = new Label();
        GridPane.setConstraints(labelProbTwo, 0, 4);
        GridPane.setConstraints(fieldProbTwo, 1, 4);

        Label labelCoCoAvgCMC = new Label("Average CMC from CoCo:");
        labelCoCoAvgCMC.setTooltip(new Tooltip(
                "Average Converted Mana Cost\n" +
                        "from the creatures pulled by\n" +
                        "Collected Company"
        ));
        fieldCoCoAvgCMC = new Label();
        GridPane.setConstraints(labelCoCoAvgCMC, 0, 5);
        GridPane.setConstraints(fieldCoCoAvgCMC, 1, 5);

        this.getChildren().addAll(
                labelNumFetchable, fieldNumFetchable,
                labelCreatureAvgCMC, fieldCreatureAvgCMC,
                labelProbZero, fieldProbZero,
                labelProbOne, fieldProbOne,
                labelProbTwo, fieldProbTwo,
                labelCoCoAvgCMC, fieldCoCoAvgCMC
        );
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
        fieldNumFetchable.setText(String.format("%.0f", stats.get(0)));
        fieldCreatureAvgCMC.setText(String.format("%.5f", stats.get(1)));
        fieldProbZero.setText(String.format("%.5f", stats.get(2)));
        fieldProbOne.setText(String.format("%.5f", stats.get(3)));
        fieldProbTwo.setText(String.format("%.5f", stats.get(4)));
        fieldCoCoAvgCMC.setText(String.format("%.5f", stats.get(5)));
    }

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
