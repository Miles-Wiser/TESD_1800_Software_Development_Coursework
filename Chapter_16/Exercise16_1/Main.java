import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    protected Text text = new Text(75, 80, "JavaFX Programming");

    public void start(Stage primaryStage) {
        

        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("LabelWithGraphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

     protected BorderPane getPane() {

        // Fonts
        Font fontBoldItalic = Font.font("Times New Roman",
            FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman",
            FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman",
            FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman",
            FontWeight.NORMAL, FontPosture.REGULAR, 20);

        // Buttons
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        // Checkboxes
        VBox paneForChBox = new VBox(20);
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalics = new CheckBox("Italics");
        paneForChBox.getChildren().addAll(chkBold, chkItalics);
        paneForChBox.setAlignment(Pos.TOP_LEFT);
        paneForChBox.setStyle("-fx-border-color: green");

        // Radio Buttons
        VBox paneForRB = new VBox(20);
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRB.setAlignment(Pos.TOP_LEFT);
        paneForRB.setStyle("-fx-border-color: green");

        // Toggle Group for Radio Buttons
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        paneForRB.getChildren().addAll(rbRed, rbGreen, rbBlue);

        // Text Field
        BorderPane paneForTF = new BorderPane();
        paneForTF.setStyle("-fx-border-color: green");
        paneForTF.setLeft(new Label("Enter a new message:"));

        // PasswordField tf = new PasswordField();
        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTF.setCenter(tf);

        tf.setOnAction(e -> text.setText(tf.getText()));
        


        // Borderpane for everything
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
        pane.setRight(paneForChBox);
        pane.setLeft(paneForRB);
        pane.setTop(paneForTF);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        // Button Events
        btLeft.setOnAction(e -> text.setX(text.getX() - 50));
        btRight.setOnAction(e -> text.setX(text.getX() + 50));

        // Checkbox Events
        chkBold.setOnAction(e -> {
            if (chkBold.isSelected() && chkItalics.isSelected())
                text.setFont(fontBoldItalic);
            else if (chkBold.isSelected())
                text.setFont(fontBold);
            else if (chkItalics.isSelected())
                text.setFont(fontItalic);
            else
                text.setFont(fontNormal);
        });
        chkItalics.setOnAction(e -> {
            if (chkBold.isSelected() && chkItalics.isSelected())
                text.setFont(fontBoldItalic);
            else if (chkBold.isSelected())
                text.setFont(fontBold);
            else if (chkItalics.isSelected())
                text.setFont(fontItalic);
            else
                text.setFont(fontNormal);
        });

        // Radio Buttons event
        rbRed.setOnAction(e -> {
            if (rbRed.isSelected())
                text.setFill(Color.RED);
        });
        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected())
                text.setFill(Color.GREEN);
        });
        rbBlue.setOnAction(e -> {
            if (rbBlue.isSelected())
                text.setFill(Color.BLUE);
        });

        return pane;
    }
}

