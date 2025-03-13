import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  private boolean hourHandVisible = true;
  private boolean minuteHandVisible = true;
  private boolean secondHandVisible = true;  
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /** Construct a clock with specified hour, minute, second, hourHandVisible
   * minuteHandVisible, and secondHandVisible */
  public ClockPane(int hour, int minute, int second, boolean hourHandVisible,
    boolean minuteHandVisible, boolean secondHandVisible) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    this.hourHandVisible = hourHandVisible;
    this.minuteHandVisible = minuteHandVisible;
    this.secondHandVisible = secondHandVisible;
  }

  /** Return hour */
  public int getHour() {
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }

  /** Return hourHandVisible */
  public boolean isHourHandVisible() {
    return hourHandVisible;
  }

  /** Set a new hourHandVisible */
  public void setHourHandVisible(boolean hourHandVisible) {
    this.hourHandVisible = hourHandVisible;
    paintClock();
  }

  /** Return minuteHandVisible */
  public boolean isMinuteHandVisible() {
    return minuteHandVisible;
  }

  /** Set a new minuteHandVisible */
  public void setMinuteHandVisible(boolean minuteHandVisible) {
    this.minuteHandVisible = minuteHandVisible;
    paintClock();
  }

  /** Return secondHandVisible */
  public boolean isSecondHandVisible() {
    return secondHandVisible;
  }

  /** Set a new secondHandVisible */
  public void setSecondHandVisible(boolean secondHandVisible) {
    this.secondHandVisible = secondHandVisible;
    paintClock();
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
    // Initialize clock parameters
    double clockRadius = 
      Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    // Draw circle
    final double VAL_SQRT = Math.sqrt(3) / 2;
    final double VAL_HALF = .5;
    final double INNER_RADIUS_P =  clockRadius - 15;
    final double INNER_RADIUS_N =  clockRadius - 3;
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);

    Text t1 = new Text(centerX - 6, centerY - INNER_RADIUS_P, "12");
    Text t2 = new Text(centerX - INNER_RADIUS_N + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + INNER_RADIUS_P + 3, centerY + 3, "3");
    Text t4 = new Text(centerX - 6, centerY + INNER_RADIUS_P + 12, "6");

    Text tOne = new Text(centerX + (INNER_RADIUS_P * VAL_HALF), centerY - (INNER_RADIUS_P * VAL_SQRT), "1");
    Text tSeven = new Text(centerX -(INNER_RADIUS_N * VAL_HALF), centerY + (INNER_RADIUS_N * VAL_SQRT), "7");
    Text tFive = new Text(centerX + (INNER_RADIUS_P * VAL_HALF), centerY + (INNER_RADIUS_N * VAL_SQRT), "5");
    Text tEleven = new Text(centerX - (INNER_RADIUS_N * VAL_HALF), centerY - (INNER_RADIUS_P * VAL_SQRT), "11");

    Text tTwo = new Text(centerX + (INNER_RADIUS_P * VAL_SQRT), centerY - (INNER_RADIUS_P * VAL_HALF), "2");
    Text tEight = new Text(centerX -(INNER_RADIUS_N * VAL_SQRT), centerY + (INNER_RADIUS_N * VAL_HALF), "8");
    Text tFour = new Text(centerX + (INNER_RADIUS_P * VAL_SQRT), centerY + (INNER_RADIUS_N * VAL_HALF), "4");
    Text tTen = new Text(centerX - (INNER_RADIUS_N * VAL_SQRT), centerY - (INNER_RADIUS_P * VAL_HALF), "10");
    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * 
      Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * 
      Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);

    // Draw minute hand
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * 
      Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * 
      Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);
    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * 
      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    
    getChildren().clear();  
    getChildren().addAll(circle, t1, t2, t3, t4, tOne, tSeven, tFive, tEleven, tTwo, tTen, tEight, tFour);
    if (secondHandVisible)
      getChildren().add(sLine);
    if (minuteHandVisible)
      getChildren().add(mLine);
    if (hourHandVisible)
      getChildren().add(hLine);
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
}
