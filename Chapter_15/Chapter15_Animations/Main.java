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