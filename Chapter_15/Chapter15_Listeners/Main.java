import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	Ball ball = new Ball();

		// Buttons
		Button btnUp = new Button("Up");
		Button btnDown = new Button("Down");
		Button btnLeft = new Button("Left");
		Button btnRight = new Button("Right");

		btnUp.setOnAction(e -> ball.up());
		btnDown.setOnAction(e -> ball.down());
		btnLeft.setOnAction(e -> ball.left());
		btnRight.setOnAction(e -> ball.right());

		// HBox
		HBox hBox = new HBox(15);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btnUp, btnDown, btnLeft, btnRight);

		// Pane
		BorderPane pane = new BorderPane();
		pane.setCenter(ball);
		pane.setBottom(hBox);
    	
    	// Create Scene and stage it
    	Scene scene = new Scene(pane, 300, 300);
    	primaryStage.setTitle("Exercise-Listener");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
}