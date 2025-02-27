import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	// temporary pane
    	TextLR pane = new TextLR();
    	
    	
    	// Scene and Stage
    	Scene scene = new Scene(pane, 500, 300);
    	primaryStage.setTitle("Exercise 16-1");
    	primaryStage.setScene(scene);
    	primaryStage.show();

    }
}