import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

class MyPolygon extends Pane {
	private void paint() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s represents the number of sides of the shape
		int s = 5;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}     
		
		getChildren().clear();
		getChildren().add(polygon);

		// rectangle
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.ORANGE);
		getChildren().add(rectangle);

		// Create path transition
		PathTransition path = new PathTransition();
		path.setDuration(Duration.millis(3000));
		path.setPath(polygon);
		path.setNode(rectangle);
		path.setOrientation(
			PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		path.setCycleCount(Timeline.INDEFINITE);
		path.setAutoReverse(true);
		path.play();
		
		// Create fade transition
		FadeTransition fade = new FadeTransition(Duration.millis(3000), rectangle);
		fade.setFromValue(1.0);
		fade.setToValue(0.1);
		fade.setCycleCount(Timeline.INDEFINITE);
		fade.setAutoReverse(true);
		fade.play();
		
		// Pause and start
		polygon.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				fade.play();
				path.play();
			}

			else if (e.getButton() == MouseButton.SECONDARY) {
				fade.pause();
				path.pause();
			}
		});
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}
