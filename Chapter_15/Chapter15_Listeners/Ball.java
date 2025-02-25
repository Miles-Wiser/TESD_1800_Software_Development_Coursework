import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends BorderPane {
	private final double RADIUS = 20;
	private double x = RADIUS, y = RADIUS;
	private Circle circle = new Circle(x, y, RADIUS);

	public Ball() {
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.rgb((int)(Math.random() * 255),
			(int)(Math.random() * 255), (int)(Math.random() * 255)));
		getChildren().add(circle);
	}

	// x methods
	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return x;
	}

	// y methods
	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}

	/** Moves the ball up */
	public void up() {
		if (y > RADIUS || y > getHeight() - RADIUS) {
			circle.setCenterY(getY() - 25);
			setY(getY() - 25);
		}
	}

	/** Moves the ball down */
	public void down() {
		if (y < RADIUS || y < getHeight() - (RADIUS + 25)) {
			circle.setCenterY(getY() + 25);
			setY(getY() + 25);
		}
	}

	/** Moves the ball left */
	public void left() {
		if (x > RADIUS || x > getWidth() - RADIUS) {
			circle.setCenterX(getX() - 25);
			setX(getX() - 25);
		}
	}

	/** Moves the ball right */
	public void right() {
		if (x < RADIUS || x < getWidth() - RADIUS) {
			circle.setCenterX(getX() + 25);
			setX(getX() + 25);
		}
	}
}