
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author sohailgsais
 */
public class TopContainer {

    Timeline timeLine = new Timeline();
    int hours = 0;
    int mins = 0;
    int secs = 0;

    Pane elapsedTime() {
        HBox pane = new HBox(2);
        VBox btns = new VBox(3);

        Button startBtn = new CustomButton("Start", 70, 30);
        startBtn.setTextFill(Color.WHITE);
        Button stopBtn = new CustomButton("Stop", 70, 30);
        stopBtn.setTextFill(Color.WHITE);
        Button resetBtn = new CustomButton("Reset", 70, 30);
        resetBtn.setTextFill(Color.WHITE);

        btns.getChildren().add(startBtn);
        btns.getChildren().add(stopBtn);
        btns.getChildren().add(resetBtn);
        startBtn.setStyle("-fx-border-color: white;" + "-fx-background-color: blue;"
                + "-fx-border-radius: 3;");
        stopBtn.setStyle("-fx-border-color: white;" + "-fx-background-color: blue;"
                + "-fx-border-radius: 3;");
        resetBtn.setStyle("-fx-border-color: white;" + "-fx-background-color: blue;"
                + "-fx-border-radius: 3;");
        btns.setStyle("-fx-border-color: white;" + "-fx-border-color: none;");

        btns.setPadding(new Insets(20, 10, 20, 30));

        Label timer = getLabel("00:00:00", 30, 50, 30, 50);
        timer.setTextFill(Color.RED);
        timer.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:50 Ariel");

        pane.getChildren().add(timer);
        pane.getChildren().add(btns);
        pane.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-border-width:2;");

        timeLine = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            stopWatch(timer, stopBtn);
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.setAutoReverse(false);

        startBtn.setOnAction((ActionEvent e) -> {

            timeLine.play();
        });
        stopBtn.setOnAction(e -> {
            timeLine.pause();
        });

        resetBtn.setOnAction(e -> {
            hours = 0;
            mins = 0;
            secs = 0;

            timeLine.pause();
            timer.setText("00:00:00");
        });

        return pane;
    }

    Pane topSection() {
        HBox container = new HBox(2);
        StackPane clock = new StackPane();
        StackPane elapsTime = new StackPane();

        Label timeTitle = new Label("Day Time Clock");
        StackPane.setAlignment(timeTitle, Pos.TOP_LEFT);
        
        timeTitle.setBackground(new Background(new BackgroundFill(Color.rgb(101, 67, 33), new CornerRadii(5.0), new Insets(-5.0))));
        timeTitle.setTextFill(Color.WHITE);
        
        Label time = getLabel("12:30:22", 40, 70, 50, 70);
        clock.getChildren().addAll(time,timeTitle);
        time.setTextFill(Color.GREEN);
        container.getChildren().add(clock);
        
        Label countDownTitle = new Label("Elapsed Time");
        StackPane.setAlignment(countDownTitle, Pos.TOP_LEFT);
        
        countDownTitle.setBackground(new Background(new BackgroundFill(Color.rgb(101, 67, 33), new CornerRadii(5.0), new Insets(-5.0))));
        countDownTitle.setTextFill(Color.WHITE);
        
        elapsTime.getChildren().addAll(elapsedTime(),countDownTitle);
        container.getChildren().add(elapsTime);
        container.setSpacing(30);
        container.setPadding(new Insets(10, 10, 10, 30));

        displayCurrTime(time);

        return container;

    }

    Label getLabel(String text, int top, int right, int bottom, int left) {
        Label label = new Label(text);
        label.setPadding(new Insets(top, right, bottom, left));
        label.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-font:50 Ariel");

        return label;

    }

    public void displayCurrTime(Label time) {
        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                while (true) {
                    Platform.runLater(() -> {
                        GregorianCalendar date = new GregorianCalendar();
                        String hrs = String.format("%02d", date.get(Calendar.HOUR_OF_DAY));
                        String mins = String.format("%02d", date.get(Calendar.MINUTE));
                        String secs = String.format("%02d", date.get(Calendar.SECOND));
                        String currentTime = "" + hrs + ":" + mins + ":" + secs;
                        time.setText(currentTime);
                    });
                    Thread.sleep(1000);
                }
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

    }

    public void stopWatch(Label timer, Button b) {

        if (secs == 60) {
            mins++;
            secs = 0;

        }
        if (mins == 60) {
            hours++;
            mins = 0;

        }

        String hrs = String.format("%02d", hours);
        String mns = String.format("%02d", mins);
        String scs = String.format("%02d", secs++);
        String time = hrs + ":" + mns + ":" + scs;

        timer.setText(time);

    }

}
