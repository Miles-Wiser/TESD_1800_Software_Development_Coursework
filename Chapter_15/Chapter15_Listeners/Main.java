import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	BallPane ballPane = new BallPane();
    	
    	Button btnUp = new Button("Up");
    	Button btnDown = new Button("Down");

    	ballPane.getChildren().addAll(btnUp, btnDown);
    	
    	// Create Scene and stage it
    	Scene scene = new Scene(ballPane, 300, 300);
    	primaryStage.setTitle("Rotating Rectangle");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
}