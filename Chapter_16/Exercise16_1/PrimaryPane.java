import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PrimaryPane extends BorderPane {
	protected Text text = new Text(50, 50, "Programming is Fun!");
	private Font ftBold = Font.font("Times New Roman",
            FontWeight.BOLD, FontPosture.REGULAR, 25);
	
	public PrimaryPane() {
		text.setFont(ftBold);
		setCenter(text);
	}
	
	public PrimaryPane(String s) {
		text.setText(s);
		text.setFont(ftBold);
		setCenter(text);
	}
	
	public void setText(String s) {
		text.setText(s);
	}
	public String getText() {
		return text.getText();
	}
}
