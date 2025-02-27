import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
public class TextLR extends RadBtn {
	private Button btLeft = new Button("<=");
	private Button btRight = new Button("=>");
	
	public TextLR() {
		super();
		
		// HBox for super pane
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setStyle("-fx-border-color: black");
		hBox.setPadding(new Insets(5, 0, 5, 0));
		
		hBox.getChildren().addAll(btLeft, btRight);

		// Set hBox pane in super pane
		super.setBottom(hBox);
		
		// Button events
        btLeft.setOnAction(e -> text.setX(text.getX() - 50));
        btRight.setOnAction(e -> text.setX(text.getX() + 50));
	}
	
}
