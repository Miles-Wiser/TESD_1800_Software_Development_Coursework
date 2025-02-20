import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class MyPolygon extends Pane {
	private void paint() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s represents the number of sides of the shape
		int s = 8;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s 
                + (Math.PI / s ))); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s 
                + (Math.PI / s)));
		}     
		
		getChildren().clear();
		getChildren().add(polygon);

        // Generate Sign text at the center of the sign, roughly
        Text signText = new Text(centerX - radius * .5, centerY + radius * .125,
            "Stop");
        signText.setFont(Font.font(radius * .5));
        signText.setFill(Color.WHITE);
        getChildren().add(signText);
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
