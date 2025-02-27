import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PrimaryPane extends BorderPane {
	protected Text text = new Text(50, 50, "Programming is Fun!");
	private Font ftBold = Font.font("Times New Roman",
            FontWeight.BOLD, FontPosture.REGULAR, 25);

	private Button btLeft = new Button("<=");
	private Button btRight = new Button("=>");

	private RadioButton rdRed = new RadioButton("Red");
	private RadioButton rdGreen = new RadioButton("Green");
	private RadioButton rdBlue = new RadioButton("Blue");
	private RadioButton rdBlack = new RadioButton("Black");
	private RadioButton rdRandom = new RadioButton("Random");
	
	public PrimaryPane() {
		text.setFont(ftBold);
		setCenter(text);
		RadBtn();
		TextLR();
	}

	// Creates two buttons that move text left or right.
	public void TextLR() {
		// HBox for super pane
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setStyle("-fx-border-color: black");
		hBox.setPadding(new Insets(5, 0, 5, 0));
		
		hBox.getChildren().addAll(btLeft, btRight);

		// Set hBox pane in super pane
		setBottom(hBox);
		
		// Button events
        btLeft.setOnAction(e -> text.setX(text.getX() - 50));
        btRight.setOnAction(e -> text.setX(text.getX() + 50));
	}

	/* Creates radio buttons that change text.fill() to red, green, blue, black,
	or a random color. */
	public void RadBtn() {
		// Create HBox
		HBox hBox = new HBox(40);
		hBox.setAlignment(Pos.CENTER);
		hBox.setStyle("-fx-border-color: black");
		hBox.getChildren().addAll(rdRed, rdGreen, rdBlue, rdBlack, rdRandom);
		
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
		
		// Set hBox pane in super pane
		super.setTop(hBox);
		
		// rd button events
		redEvent();
		greenEvent();
		blueEvent();
		blackEvent();
		randomEvent();
	}
	
	private void redEvent() {
		rdRed.setOnAction(e -> {
			if (rdRed.isSelected())
				text.setFill(Color.RED);
		});
	}
	
	private void greenEvent() {
		rdGreen.setOnAction(e -> {
			if (rdGreen.isSelected())
				text.setFill(Color.GREEN);
		});
	}
	
	private void blueEvent() {
		rdBlue.setOnAction(e -> {
			if (rdBlue.isSelected())
				text.setFill(Color.BLUE);
		});
	}
	
	private void blackEvent() {
		rdBlack.setOnAction(e -> {
			if (rdBlack.isSelected())
				text.setFill(Color.BLACK);
		});
	}
	
	private void randomEvent() {
		rdRandom.setOnAction(e -> {
			if (rdRandom.isSelected()) {
				int r = (int)(Math.random() * 255);
				int g = (int)(Math.random() * 255);
				int b = (int)(Math.random() * 255);
				text.setFill(Color.rgb(r, g, b));
			}
		});
	}
}
