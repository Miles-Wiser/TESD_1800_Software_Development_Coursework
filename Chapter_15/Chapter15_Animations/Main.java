/*
Author: Miles Wiser
Date: 2/25/2025

	This program creates a rectangle and pentagon. While the rectangle rotates
	around the pentagon facing orthogonal to the pentagon's center, it will also
	fade in and out. Additionally, the user can pause or play the animation of
	the rectangle by pressing right and left, respectively.
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
		MyPolygon myPolygon = new MyPolygon();

    	// Create Scene and stage it
    	Scene scene = new Scene(myPolygon, 300, 300);
    	primaryStage.setTitle("Exercise-Animation");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
}