package View.MainPage;

import Model.ChartDataHolder;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class _MainPage extends Scene {

    // Backend for the Main Page
    private ChartDataHolder backend;

    public _MainPage(Parent root, double width, double height) {
        super(root, width, height);
        backend = new ChartDataHolder();

        VBox lineCharts = new VBox();
        lineCharts.getChildren().addAll(
                new LineGraphDisplay(backend, 1), new Separator(),
                new LineGraphDisplay(backend, 2), new Separator(),
                new LineGraphDisplay(backend, 3)
        );

        // Collection of all the UI elements for the application
        VBox wholeUI = new VBox();
        wholeUI.getChildren().addAll(
                new UserInput(backend), new Separator(),
                new TextOutput(backend), new Separator(),
                new PieChartDisplay(backend)
        );

        HBox both = new HBox();
        both.getChildren().addAll(
                wholeUI, new Separator(Orientation.VERTICAL), lineCharts
        );

        this.setRoot(both);
    }

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////
}
