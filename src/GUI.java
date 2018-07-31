import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Written by Michael Schuetze on 7/29/2018.
 */
public class GUI extends Application {

    // Variables to store user input
    private int oneDrops;
    private int twoDrops;
    private int threeDrops;

    // Variables to store output to the user
    private Label fieldNumFetchable;
    private Label fieldCreatureAvgCMC;
    private Label fieldProbZero;
    private Label fieldProbOne;
    private Label fieldProbTwo;
    private Label fieldCoCoAvgCMC;

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CoCo Maths");

        Label label1Drops = new Label("Number of 1 Drops:");
        TextField input1Drops = new TextField();
        input1Drops.setPrefColumnCount(3);
        HBox ui1Drops = new HBox();
        ui1Drops.getChildren().addAll(label1Drops, input1Drops);

        Label label2Drops = new Label("Number of 2 Drops:");
        TextField input2Drops = new TextField();
        input2Drops.setPrefColumnCount(3);
        HBox ui2Drops = new HBox();
        ui2Drops.getChildren().addAll(label2Drops, input2Drops);

        Label label3Drops = new Label("Number of 3 Drops:");
        TextField input3Drops = new TextField();
        input3Drops.setPrefColumnCount(3);
        HBox ui3Drops = new HBox();
        ui3Drops.getChildren().addAll(label3Drops, input3Drops);

        Button calcButton = new Button("Calculate");
        calcButton.setOnAction(event -> {
            oneDrops = validateInt(input1Drops, input1Drops.getText());
            twoDrops = validateInt(input2Drops, input2Drops.getText());
            threeDrops = validateInt(input3Drops, input3Drops.getText());

            if (oneDrops != -1 && twoDrops != -1 && threeDrops != -1)
                displayStatistics(Statistics.compute(oneDrops, twoDrops, threeDrops));
        });

        // Collection of all the user input elements
        VBox interactionElements = new VBox();
        interactionElements.getChildren().addAll(ui1Drops, ui2Drops, ui3Drops, calcButton);

        // Used to separate user input and output
        Separator separator = new Separator();

        GridPane displayElements = new GridPane();
        displayElements.setPadding(new Insets(10, 10, 10, 10));
        displayElements.setHgap(15);

        Label labelNumFetchable = new Label("Number of Fetchable Creatures:");
        labelNumFetchable.setTooltip(new Tooltip(
                "Number of creatures in the\n" +
                "deck that could be pulled by\n" +
                "Collected Company"
        ));
        fieldNumFetchable = new Label();
        GridPane.setConstraints(labelNumFetchable, 0, 0);
        GridPane.setConstraints(fieldNumFetchable, 1, 0);
//        HBox uiNumFetchable = new HBox();
//        uiNumFetchable.getChildren().addAll(labelNumFetchable, fieldNumFetchable);

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
//        HBox uiCreatureAvgCMC = new HBox();
//        uiCreatureAvgCMC.getChildren().addAll(labelCreatureAvgCMC, fieldCreatureAvgCMC);

        Label labelProbZero = new Label("P[0] Creatures:");
        labelProbZero.setTooltip(new Tooltip(
                "Probability of pulling\n" +
                "0 creatures from\n" +
                "Collected Company"
        ));
        fieldProbZero = new Label();
        GridPane.setConstraints(labelProbZero, 0, 2);
        GridPane.setConstraints(fieldProbZero, 1, 2);
//        HBox uiProbZero = new HBox();
//        uiProbZero.getChildren().addAll(labelProbZero, fieldProbZero);

        Label labelProbOne = new Label("P[1] Creatures:");
        labelProbOne.setTooltip(new Tooltip(
                "Probability of pulling\n" +
                "1 creature from\n" +
                "Collected Company"
        ));
        fieldProbOne = new Label();
        GridPane.setConstraints(labelProbOne, 0, 3);
        GridPane.setConstraints(fieldProbOne, 1, 3);
//        HBox uiProbOne = new HBox();
//        uiProbOne.getChildren().addAll(labelProbOne, fieldProbOne);

        Label labelProbTwo = new Label("P[2] Creatures:");
        labelProbTwo.setTooltip(new Tooltip(
                "Probability of pulling\n" +
                "2 creatures from\n" +
                "Collected Company"
        ));
        fieldProbTwo = new Label();
        GridPane.setConstraints(labelProbTwo, 0, 4);
        GridPane.setConstraints(fieldProbTwo, 1, 4);
//        HBox uiProbTwo = new HBox();
//        uiProbTwo.getChildren().addAll(labelProbTwo, fieldProbTwo);

        Label labelCoCoAvgCMC = new Label("Average CMC from CoCo:");
        labelCoCoAvgCMC.setTooltip(new Tooltip(
                "Average Converted Mana Cost\n" +
                "from the creatures pulled by\n" +
                "Collected Company"
        ));
        fieldCoCoAvgCMC = new Label();
        GridPane.setConstraints(labelCoCoAvgCMC, 0, 5);
        GridPane.setConstraints(fieldCoCoAvgCMC, 1, 5);
//        HBox uiCoCoAvgCMC = new HBox();
//        uiCoCoAvgCMC.getChildren().addAll(labelCoCoAvgCMC, fieldCoCoAvgCMC);

//        // Collection of the elements displaying information to the user
//        VBox displayElements = new VBox();
//        displayElements.getChildren().addAll(uiNumFetchable, uiCreatureAvgCMC,
//                uiProbZero, uiProbOne, uiProbTwo, uiCoCoAvgCMC);

        displayElements.getChildren().addAll(
                labelNumFetchable, fieldNumFetchable,
                labelCreatureAvgCMC, fieldCreatureAvgCMC,
                labelProbZero, fieldProbZero,
                labelProbOne, fieldProbOne,
                labelProbTwo, fieldProbTwo,
                labelCoCoAvgCMC, fieldCoCoAvgCMC
        );

        // Collection of all the UI elements for the application
        VBox wholeUI = new VBox();
        wholeUI.getChildren().addAll(interactionElements, separator, displayElements);

        // Create the main page of the application
        Scene mainPage = new Scene(wholeUI, 300, 270);

        primaryStage.setScene(mainPage);
        primaryStage.show();
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /**
     * Validates whether or not the user inputted correct data
     * @param inputField- the field the input came from
     * @param fieldValue- the input value from the user
     * @return integer value the user gave as input or -1
     */
    private int validateInt(TextField inputField, String fieldValue) {
        try {
            return Integer.parseInt(fieldValue);
        } catch (NumberFormatException e) {
            inputField.setText("");
        }

        return -1;
    }

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

    public static void main(String[] args) {
        launch(args);
    }
}
