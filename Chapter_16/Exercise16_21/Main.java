/*
Author: Miles Wiser
Date: 2/27/2025

	This programs displays a string in a window. The text's color and horizontal
postion can be manipulated using radio and regular buttons.
*/

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    	
    	Text txtTimeEntry = new Text(tfTimeEntry.getText());
    	primaryPane.setCenter(txtTimeEntry);
    	
    	tfTimeEntry.setOnAction(e -> {
    		tfTimeEntry.setText(tfTimeEntry.getText());
    		txtTimeEntry.setText(tfTimeEntry.getText());
    	});
    	
    	
    	
    	Timeline animation = new Timeline(Duration.millis(1000), eventHandler);
    	animation.setCycleCount(Timeline.INDEFINITE);
    	animation.play();
    	
    	// Scene and Stage
    	Scene scene = new Scene(primaryPane, 500, 300);
    	primaryStage.setTitle("Exercise 16-2");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	
    }

}