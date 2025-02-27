import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class RadBtn extends PrimaryPane {
	private RadioButton rdRed = new RadioButton("Red");
	private RadioButton rdGreen = new RadioButton("Green");
	private RadioButton rdBlue = new RadioButton("Blue");
	private RadioButton rdBlack = new RadioButton("Black");
	private RadioButton rdRandom = new RadioButton("Random");

	public RadBtn() {
		super();
		
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
	
	public void redEvent() {
		rdRed.setOnAction(e -> {
			if (rdRed.isSelected())
				super.text.setFill(Color.RED);
		});
	}
	
	public void greenEvent() {
		rdGreen.setOnAction(e -> {
			if (rdGreen.isSelected())
				super.text.setFill(Color.GREEN);
		});
	}
	
	public void blueEvent() {
		rdBlue.setOnAction(e -> {
			if (rdBlue.isSelected())
				super.text.setFill(Color.BLUE);
		});
	}
	
	public void blackEvent() {
		rdBlack.setOnAction(e -> {
			if (rdBlack.isSelected())
				super.text.setFill(Color.BLACK);
		});
	}
	
	public void randomEvent() {
		rdRandom.setOnAction(e -> {
			if (rdRandom.isSelected()) {
				int r = (int)(Math.random() * 255);
				int g = (int)(Math.random() * 255);
				int b = (int)(Math.random() * 255);
				super.text.setFill(Color.rgb(r, g, b));
			}
		});
	}
}
