package View;

import View.MainPage._MainPage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Written by Michael Schuetze on 8/1/2018.
 */
public class GUI extends Application {

    /////////////////////////////////////////////////////
    //              Class Functionality
    /////////////////////////////////////////////////////

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CoCo Maths");

        // Create the main page of the application
        Scene mainPage = new _MainPage(new Group(), 300, 550);

        primaryStage.setScene(mainPage);
        primaryStage.show();
    }

    /////////////////////////////////////////////////////
    //              Getters and Setters
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Helper Functions
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////
    //               Testing Purposes
    /////////////////////////////////////////////////////

    public static void main(String[] args) {
        launch(args);
    }
}
