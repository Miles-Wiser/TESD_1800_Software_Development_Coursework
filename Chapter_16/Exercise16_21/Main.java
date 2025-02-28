/*
Author: Miles Wiser
Date: 2/28/2025

	This program asks the user to enter a time in seconds. Upon pressing enter,
the time will appear in the middle of the screen and begin counting down. When
finished, audio will play until the program is closed.
*/

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
	    // Primary pane
    	BorderPane primaryPane = new BorderPane();
    	
    	// Text Field and Label
    	HBox hBox = new HBox(5);
    	hBox.setAlignment(Pos.CENTER);
    	
    	TextField tfTimeEntry = new TextField();
    	
    	Label lbTimeEntry = new Label("Enter a time in seconds:");
    	tfTimeEntry.setOnAction(e -> {
    		tfTimeEntry.setText(tfTimeEntry.getText());
    		System.out.println(tfTimeEntry.getText());
    	});
    	
    	hBox.getChildren().setAll(lbTimeEntry, tfTimeEntry);
    	primaryPane.setTop(hBox);
    	
		// Countdown
    	Text txtCountdown = new Text(tfTimeEntry.getText());
    	primaryPane.setCenter(txtCountdown);

    	tfTimeEntry.setOnAction(ev -> {
    		tfTimeEntry.setText(tfTimeEntry.getText());
    		txtCountdown.setText(tfTimeEntry.getText());

			Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(1000),
					// Take time remaining and subtract one; Display remaining time.
					e -> {
						int intTime = Integer.parseInt(txtCountdown.getText()) - 1;
						txtCountdown.setText("" + intTime);
						System.out.println(intTime + "seconds");

					}
				)
			);

			animation.setCycleCount(Integer.parseInt(txtCountdown.getText()));
			animation.play();

			// Audio
			final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
			Media media = new Media(MEDIA_URL);
			MediaPlayer mediaPlayer = new MediaPlayer(media);

			animation.setOnFinished(e -> mediaPlayer.play());
    	});
    	
    	// Scene and Stage
    	Scene scene = new Scene(primaryPane, 500, 300);
    	primaryStage.setTitle("Exercise 16-2");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	
    }

}