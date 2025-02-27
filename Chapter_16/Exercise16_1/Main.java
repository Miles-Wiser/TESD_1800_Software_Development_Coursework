/*
Author: Miles Wiser
Date: 2/27/2025

	This programs displays a string in a window. The text's color and horizontal
postion can be manipulated using radio and regular buttons.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	/// BorderPane
    	BorderPane pane = new BorderPane();

		/// Text
		Pane tfPane = new Pane();
		Text text = new Text(50, 50, "Programming is fun!");
		text.setFill(Color.RED);
		Font ftBold = Font.font("Times New Roman",
        	FontWeight.BOLD, FontPosture.REGULAR, 20);
		text.setFont(ftBold);
		tfPane.getChildren().add(text);
		pane.setCenter(tfPane);

		/// Buttons
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		
		// Create HBox
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setStyle("-fx-border-color: black");
		hBox.setPadding(new Insets(5, 0, 5, 0));
		
		hBox.getChildren().addAll(btLeft, btRight);

		// Set hBox pane in super pane
		pane.setBottom(hBox);
		
		// Button events
        btLeft.setOnAction(e -> text.setX(text.getX() - 50));
        btRight.setOnAction(e -> text.setX(text.getX() + 50));

		/// Radio Buttons
		RadioButton rdRed = new RadioButton("Red");
		RadioButton rdGreen = new RadioButton("Green");
		RadioButton rdBlue = new RadioButton("Blue");
		RadioButton rdBlack = new RadioButton("Black");
		RadioButton rdRandom = new RadioButton("Random");

		// Create HBox
		HBox hBox2 = new HBox(40);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.setStyle("-fx-border-color: black");
		hBox2.getChildren().addAll(rdRed, rdGreen, rdBlue, rdBlack, rdRandom);
		pane.setTop(hBox2);
		
		// Create ToggleGroup
		ToggleGroup group = new ToggleGroup();
		rdRed.setToggleGroup(group);
		rdGreen.setToggleGroup(group);
		rdBlue.setToggleGroup(group);
		rdBlack.setToggleGroup(group);
		rdRandom.setToggleGroup(group);
		
		rdRed.setPadding(new Insets(5, 0, 5, 0));
		rdGreen.setPadding(new Insets(5, 0, 5, 0));
		rdBlue.setPadding(new Insets(5, 0, 5, 0));
		rdBlack.setPadding(new Insets(5, 0, 5, 0));
		rdRandom.setPadding(new Insets(5, 0, 5, 0));
		
		// rd button events

		rdRed.setOnAction(e -> {
			if (rdRed.isSelected())
				text.setFill(Color.RED);
		});

		rdGreen.setOnAction(e -> {
			if (rdGreen.isSelected())
				text.setFill(Color.GREEN);
		});

		rdBlue.setOnAction(e -> {
			if (rdBlue.isSelected())
				text.setFill(Color.BLUE);
		});

		rdBlack.setOnAction(e -> {
			if (rdBlack.isSelected())
				text.setFill(Color.BLACK);
		});

		rdRandom.setOnAction(e -> {
			if (rdRandom.isSelected()) {
				int r = (int)(Math.random() * 255);
				int g = (int)(Math.random() * 255);
				int b = (int)(Math.random() * 255);
				text.setFill(Color.rgb(r, g, b));
			}
		});
    	
    	// Scene and Stage
    	Scene scene = new Scene(pane, 500, 300);
    	primaryStage.setTitle("Exercise 16-1");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
}