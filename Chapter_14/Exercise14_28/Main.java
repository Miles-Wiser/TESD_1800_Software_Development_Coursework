/**
Author: Miles Wiser
Date: 2/20/2025

    This program creates a clock frozen on a random time. The time is also
shown numerically below the clock. The ClockPane object offers the user
visibility of the hour, minute, and second hands. The main method hides the
visibility of the second hand.
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create ClockPane with random time values
        int hourRand = (int)(Math.random() * 12);
        int minuteRand = (int)(Math.random() * 60);
        int secondRand = (int)(Math.random() * 60);

        ClockPane clock = new ClockPane(hourRand, minuteRand, secondRand);        
        clock.setSecondHandVisible(false);

        String hourRandText = "" + hourRand;
        String minuteRandText = "" + minuteRand;
        String secondRandText = "" + secondRand;
        if (hourRand == 0)
            hourRandText = "12";
        if (minuteRand < 10)
            minuteRandText = "0" + minuteRand;
        if (secondRand < 10)
            secondRandText = "0" + secondRand;
        String timeString = hourRandText + ":" + minuteRandText +
            ":" + secondRandText;

        Label lblCurrenttime = new Label(timeString);



        // Place clock
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrenttime);
        BorderPane.setAlignment(lblCurrenttime, Pos.TOP_CENTER);
        

        // Scene
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle(("Clock"));
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
