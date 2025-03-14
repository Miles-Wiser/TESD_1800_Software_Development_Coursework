/**
Author: Miles Wiser
Date: 2/20/2025

	This program visually create a stop sign using the "MyPolygon" class.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise14_15 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		Scene scene = new Scene(new MyPolygon(), 400, 400);
		primaryStage.setTitle("ShowPolygon"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}
}
