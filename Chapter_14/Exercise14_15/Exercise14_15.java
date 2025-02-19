import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise14_15 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create pane
        Pane pane = new Pane();

        // Create scene and display stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Tic-Tac-Toe Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}