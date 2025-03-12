/*
 * Author: Miles Wiser
 * Date: 3/8/2025
 * 
 *  This pace calculator creates a gui to enter a time, pace, and distance. If
 * the pace is calculated, a new gui will appear displaying the pace and times
 * that would be achieved in various race events at that pace. If the time is
 * calculated, another gui shows the splits and their cumulative times.
 * Finaly, the user can navigate back to the entry gui and provide new data.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    // Buttons
    private Button btnPace = new Button("Calculate Pace");
    private Label lblPaceBtnDesc = new Label("Enter a time and distance:", btnPace);
    private Button btnTime = new Button("Calculate Time");
    private Label lblTimeBtnDesc = new Label("Enter a pace and distance:", btnTime);
    private Button btnReturn = new Button("Return");
    
    // Time
    private TextField tfTimeHr = new TextField("00");
    private TextField tfTimeMin = new TextField("00");
    private TextField tfTimeSec = new TextField("00");
    private Label lblTime = new Label("Enter Time Here:", tfTimeHr);
    private double time;

    // Pace
    private TextField tfPaceMin = new TextField("00");
    private TextField tfPaceSec = new TextField("00");
    private Text txtPaceUnit = new Text(" min/mi");
    private Label lblPace = new Label("Enter Pace Here:", tfPaceMin);
    private double pace;
    private double paceKm;

    // Distance
    private TextField tfDistance = new TextField("0");
    private Label lblDistance = new Label("Enter Distance Here:", tfDistance);
    private Text txtDistanceUnit = new Text(" mi");
    private double distance;
    private double distanceKm;
    private boolean distanceUnit;
    final private double KILOMETER = 1.6094;

    // Panes
    Pane pane = new Pane();
    private HBox hboxTime = new HBox(25, lblTime, tfTimeMin, tfTimeSec);
    private HBox hboxPace = new HBox(25, lblPace, tfPaceSec, txtPaceUnit);
    private HBox hboxDistance = new HBox(25, lblDistance, txtDistanceUnit);
    private HBox hboxBtns = new HBox(100, lblTimeBtnDesc, lblPaceBtnDesc);
    private VBox vbox = new VBox(25, hboxTime, hboxPace, hboxDistance, hboxBtns);

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        new Entry();

        // Scene and Stage
        Scene scene = new Scene(pane, 700, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Split Calculator");
        primaryStage.show();

        /// Button Actions
        // Calculates time from pace and distance
        btnTime.setOnAction(e -> {
            setDistance();
            setPace();
            setTime();

            if (getDistance() > 0 && (Double.parseDouble(tfPaceMin.getText()) > 0
                || Double.parseDouble(tfPaceSec.getText()) > 0))
                new Splits();
        });

        // Calculate pace from time and distance
        btnPace.setOnAction(e -> {
            setDistance();
            setPace();

            if (getDistance() > 0 && getTime() > 0)
                new PopularEvents();
        });

        btnReturn.setOnAction(e -> {
            new Entry();
        });
    }

    /// Methods
    // time
    public double getTime() {
        return time;
    }
    /** If {@code t} is true, returns time from {@code pace / distance}. Else returns
     * time from time textfields.
    */
    public void setTime() {
        time = (Double.parseDouble(tfPaceMin.getText()) * 60 +
            Double.parseDouble(tfPaceSec.getText())) *
            Double.parseDouble(tfDistance.getText());
    }
    public String timeString() {
        return (int)(time / 3600) + ":" + (int)(time / 60 % 60) + ":" + (int)(time % 60);
    }

    // pace
    public double getPace() {
        return pace;
    }
    public void setPace() {
        time = Double.parseDouble(tfTimeHr.getText()) * 3600 +
                Double.parseDouble(tfTimeMin.getText()) * 60 +
                Double.parseDouble(tfTimeSec.getText());
        pace = getTime() / getDistance();
        setPaceKm();
    }
    public String paceString() {
        return (int)(pace / 60) + ":" + (int)(pace % 60);
    }

    public double getPaceKm() {
        return paceKm;
    }
    public void setPaceKm() {
        paceKm = pace / KILOMETER;
    }
    public String paceStringKm() {
        return (int)(paceKm / 60) + ":" + (int)(paceKm % 60);
    }

    // distance
    public double getDistance() {
        return distance;
    }
    public void setDistance() {
        distance = Double.parseDouble(tfDistance.getText());
        distanceKm = distance *KILOMETER;
    }
    public String distanceString() {
        return distance + "";
    }

    public double getDistanceKm() {
        return distanceKm;
    }
    public void setDistanceKm() {
        distanceKm = distance * KILOMETER;
    }
    public String distanceStringKm() {
        return distanceKm + "";
    }

    public boolean isDistanceUnit() {
        return distanceUnit;
    }

    /// Entry Class
    public class Entry {
        HBox hbox = new HBox(10);
        Entry() {
            pane.getChildren().clear();

            lblTimeBtnDesc.setContentDisplay(ContentDisplay.RIGHT);
            lblPaceBtnDesc.setContentDisplay(ContentDisplay.RIGHT);
            lblTime.setContentDisplay(ContentDisplay.RIGHT);
            lblPace.setContentDisplay(ContentDisplay.RIGHT);
            lblDistance.setContentDisplay(ContentDisplay.RIGHT);

            pane.getChildren().add(vbox);
        }
    }

    /// PopularEvents Class
    public class PopularEvents {
        // Events
        private Text[] txtEventMi = {new Text("1 mi"), new Text("3 mi"), new Text("5 mi"),
            new Text("10 mi"), new Text("Half-Marathon")};
        private Text[] txtEventKm = {new Text("400m"), new Text("800m"), new Text("5k"),
            new Text("10k"), new Text("Marathon")};

        private Label[] lblEventKm = new Label[5];
        private Label[] lblEventMi = new Label[5];

        // Panes
        private VBox vboxKm = new VBox(25);
        private VBox vboxMi = new VBox(25);
        private HBox hbox = new HBox(100, vboxKm, vboxMi, btnReturn);

        public PopularEvents() {
            pane.getChildren().clear();
            // initializes vboxKm and vboxMi element values
            for (int i = 0; i < txtEventKm.length; i++) {
                double tempPace = pace;
                double tempPaceKm = paceKm;
                switch (i) {
                    case 0:
                        tempPaceKm /= 4;
                        break;
                    case 1:
                        tempPace *= 3;
                        tempPaceKm /= 2;
                        break;
                    case 2:
                        tempPace *= 5;
                        tempPaceKm *= 5;
                        break;
                    case 3:
                        tempPace *= 10;
                        tempPaceKm *= 10;
                        break;
                    case 4:
                        tempPace *= 13.1;
                        tempPaceKm = pace * 26.2;
                        break;
                }

                // Insert timeString int element "i" and had to vboxMi to display to pane
                lblEventMi[i] = new Label(tempPaceString(tempPace), txtEventMi[i]);
                lblEventMi[i].setContentDisplay(ContentDisplay.RIGHT);
                vboxMi.getChildren().add(lblEventMi[i]);

                // Insert timeString int element "i" and had to vboxKm to display to pane
                lblEventKm[i] = new Label(tempPaceString(tempPaceKm), txtEventKm[i]);
                lblEventKm[i].setContentDisplay(ContentDisplay.RIGHT);
                vboxKm.getChildren().add(lblEventKm[i]); 
            }

            // Shows pace in km/min and mi/min
            vboxKm.getChildren().add(new Text("Pace: " + tempPaceString(paceKm) + " /km"));
            vboxMi.getChildren().add(new Text("Pace: " + tempPaceString(pace) + " /mi"));

            pane.getChildren().add(hbox);
        }

        public String tempPaceString(Double p) {
            String hrMinCol;
            String secMinCol;

            // formats to x:xx:sec
            if ((int)(p / 60 % 60) >= 10)
                hrMinCol = ":";
            else
                hrMinCol = ":0";

            // formats to hr:xx:xx
            if ((int)(p % 60) >= 10)
                secMinCol = ":";
            else
                secMinCol = ":0";

            // formats to hr:min:sec or min:sec
            if ((int)(p / 3600) > 0)
                return (int)(p / 3600) + hrMinCol + (int)(p / 60 % 60) + secMinCol + (int)(p % 60);
            else
                return (int)(p / 60 % 60) + secMinCol + (int)(p % 60);
        }
    }

    /// Splits Class
    public class Splits {
        // Only used to get (txt/lbl + Splits + Km/Mi)[] lengths
        private int arrayLenMi = (int)getDistance();
        private int arrayLenKm = (int)getDistanceKm();

        // Splits
        private Text[] txtSplitsKm = new Text[arrayLenKm];
        private Text[] txtSplitsMi = new Text[arrayLenMi];

        private Label[] lblSplitsKm = new Label[arrayLenKm];
        private Label[] lblSplitsMi = new Label[arrayLenMi];

        // Panes
        private VBox vboxKm = new VBox(25);
        private VBox vboxMi = new VBox(25);
        private HBox hbox = new HBox(100, vboxKm, vboxMi, btnReturn);

        Splits() {
            pane.getChildren().clear();

            // initializes txtSplitsKm and lblSplitsKm element values
            for (int i = 0; i < arrayLenKm; i++) {
                double tempPaceKm = pace * (i + 1) / KILOMETER;
                // Insert timeString int element "i" and had to vboxKm to display to pane
                txtSplitsKm[i] = new Text(tempPaceString(tempPaceKm) + "min");
                lblSplitsKm[i] = new Label((i + 1) + "km", txtSplitsKm[i]);
                lblSplitsKm[i].setContentDisplay(ContentDisplay.RIGHT);

                vboxKm.getChildren().add(lblSplitsKm[i]);

                // if distance has a decimal, display in last element.
                if (getDistanceKm() % 1 > 0 && i + 1 >= arrayLenKm) {
                    tempPaceKm = pace * getDistanceKm() / KILOMETER;
                    txtSplitsKm[arrayLenKm - 1] = new Text(tempPaceString(tempPaceKm) + "min");
                    lblSplitsKm[arrayLenKm - 1] = new Label((getDistanceKm()) + "km", txtSplitsKm[arrayLenKm - 1]);
                    lblSplitsKm[arrayLenKm - 1].setContentDisplay(ContentDisplay.RIGHT);
                    vboxKm.getChildren().add(lblSplitsKm[arrayLenKm - 1]);
                    
                    i++;
                }
            }

            // initializes txtSplitsMi and lblSplitsMi element values
            for (int i = 0; i < arrayLenMi; i++) {
                double tempPace = pace * (i + 1);
                // Insert timeString int element "i" and had to vboxMi to display to pane
                txtSplitsMi[i] = new Text(tempPaceString(tempPace) + "min");
                lblSplitsMi[i] = new Label((i + 1) + "mi", txtSplitsMi[i]);
                lblSplitsMi[i].setContentDisplay(ContentDisplay.RIGHT);

                vboxMi.getChildren().add(lblSplitsMi[i]);

                // if distance has a decimal, display in last element.
                if (getDistance() % 1 > 0 && i + 1 >= arrayLenMi) {
                    tempPace = pace * getDistance();
                    txtSplitsMi[arrayLenMi - 1] = new Text(tempPaceString(tempPace) + "min");
                    lblSplitsMi[arrayLenMi - 1] = new Label((getDistance()) + "mi", txtSplitsMi[arrayLenMi - 1]);
                    lblSplitsMi[arrayLenMi - 1].setContentDisplay(ContentDisplay.RIGHT);
                    vboxMi.getChildren().add(lblSplitsMi[arrayLenMi - 1]);

                    i++;
                }
            }

            pane.getChildren().add(hbox);
        }

        public String tempPaceString(Double p) {
            String hrMinCol;
            String secMinCol;

            // formats to x:xx:sec
            if ((int)(p / 60 % 60) >= 10)
                hrMinCol = ":";
            else
                hrMinCol = ":0";

            // formats to hr:xx:xx
            if ((int)(p % 60) >= 10)
                secMinCol = ":";
            else
                secMinCol = ":0";

            // formats to hr:min:sec or min:sec
            if ((int)(p / 3600) > 0)
                return (int)(p / 3600) + hrMinCol + (int)(p / 60 % 60) + secMinCol + (int)(p % 60);
            else
                return (int)(p / 60 % 60) + secMinCol + (int)(p % 60);
        }
    }
}