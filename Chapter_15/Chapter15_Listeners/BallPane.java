import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
	public final double radius = 20;
	private double x = radius, y = radius;
	private double dx = 25;
	private double dy = 25;
	private Circle circle = new Circle(x, y, radius);
	
	public BallPane() {
		circle.setFill(Color.GREEN);
		
		getChildren().add(circle);
	}
	
	public void up() {
		y -= dy;
	}
	
	public void down() {
		y += dy;
	}
}
