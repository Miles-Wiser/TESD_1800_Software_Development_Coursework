import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();


        // Place clock
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        

        // Scene
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle(("Clock"));
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
