package View.MainPage;

import Model.ChartDataHolder;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class UserInput extends VBox {

    // Backend that will be receiving data
    private ChartDataHolder backend = new ChartDataHolder();

    UserInput(ChartDataHolder backend) {
        this.backend = backend;
        start();
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    /**
     * Create the UI elements that the user will interact with
     */
    public void start() {
        Label label1Drops = new Label("Number of 1 Drops:");
        TextField input1Drops = new TextField();
        input1Drops.setPrefColumnCount(3);
        HBox ui1Drops = new HBox();
        ui1Drops.getChildren().addAll(label1Drops, input1Drops);
        ui1Drops.setAlignment(Pos.CENTER_LEFT);
        ui1Drops.setSpacing(20);

        Label label2Drops = new Label("Number of 2 Drops:");
        TextField input2Drops = new TextField();
        input2Drops.setPrefColumnCount(3);
        HBox ui2Drops = new HBox();
        ui2Drops.getChildren().addAll(label2Drops, input2Drops);
        ui2Drops.setAlignment(Pos.CENTER_LEFT);
        ui2Drops.setSpacing(20);

        Label label3Drops = new Label("Number of 3 Drops:");
        TextField input3Drops = new TextField();
        input3Drops.setPrefColumnCount(3);
        HBox ui3Drops = new HBox();
        ui3Drops.getChildren().addAll(label3Drops, input3Drops);
        ui3Drops.setAlignment(Pos.CENTER_LEFT);
        ui3Drops.setSpacing(20);

        Button calcButton = new Button("Calculate");
        calcButton.setOnAction(event -> {
            int oneDrops = validateInt(input1Drops, input1Drops.getText());
            int twoDrops = validateInt(input2Drops, input2Drops.getText());
            int threeDrops = validateInt(input3Drops, input3Drops.getText());

            backend.computeStatistics(oneDrops, twoDrops, threeDrops);
        });

        // Collection of all the user input elements
        this.getChildren().addAll(ui1Drops, ui2Drops, ui3Drops, calcButton);
        this.setAlignment(Pos.CENTER_RIGHT);
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

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
