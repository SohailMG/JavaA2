
import java.io.File;
import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author sohailgsais
 */
public class PressureControl {

    Label humidity;
    int pressureCounter;
    final int MAXPRESSURE = 120;
    final int MINPRESSURE = 50;

    Pane pressureContainer() {
        StackPane content = new StackPane();

        Label title = new Label("Pressure Control");
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        title.setTranslateY(-7);
        title.setTranslateX(10);
        
        title.setBackground(new Background(new BackgroundFill(Color.rgb(101, 67, 33), new CornerRadii(5.0), new Insets(-5.0))));
        title.setTextFill(Color.WHITE);
        content.getChildren().addAll(pressureControlContainer(),title);
        content.setPadding(new Insets(10, 10, 10, 30));

        return content;
    }

    Pane pressureControlContainer() {
        VBox container = new VBox(2);

        container.getChildren().add(pressureControls());
        container.getChildren().add(pressureControlBtns());
        container.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-border-width:2;");
        container.setPadding(new Insets(30, 0, 0, 30));

        return container;
    }

    Pane pressureControls() {
        HBox controls = new HBox(3);

        humidity = getLabel("54", 10, 10, 10, 10);
        Label tempType = getLabel("kPa", 10, 10, 10, 10);
        humidity.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:50 Ariel");
        tempType.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:20 Ariel");
        humidity.setTextFill((javafx.scene.paint.Color.RED));
        tempType.setTextFill((javafx.scene.paint.Color.WHITE));

        controls.getChildren().add(getImage("pressure-icon.png", 50, 50));
        controls.getChildren().add(humidity);
        controls.getChildren().add(tempType);

        return controls;
    }

    Pane pressureControlBtns() {
        HBox btns = new HBox(2);

        Button btnUp = new CustomButton("Up", 50, 50);
        btnUp.setGraphic(getImage("up-icon.png", 50, 50));
        btnUp.setPadding(new Insets(10, 20, 10, 0));
        btnUp.setStyle("-fx-border-radius:10;");

        Button btnDown = new CustomButton("Down", 50, 50);
        btnDown.setGraphic(getImage("down-icon.png", 50, 50));
        btnDown.setPadding(new Insets(10, 20, 10, 0));
        btnDown.setStyle("-fx-border-radius:10;");

        btns.setPadding(new Insets(10));
        btns.getChildren().add(btnDown);
        btns.getChildren().add(btnUp);

        btns.setSpacing(20);

        btnUp.setOnAction(e -> {
            int currentHumidity = Integer.parseInt(humidity.getText());

            pressureCounter = currentHumidity;
            int potentialTotal = currentHumidity + 10;

            if (pressureCounter < MAXPRESSURE && potentialTotal < MAXPRESSURE) {
                String newHumidity = Integer.toString(pressureCounter += 10);
                humidity.setText(newHumidity);

            }

        });
        btnDown.setOnAction(e -> {

            int currentHumidity = Integer.parseInt(humidity.getText());
            pressureCounter = currentHumidity;
            int potentialTotal = currentHumidity - 10;
            if (pressureCounter > MINPRESSURE && potentialTotal > MINPRESSURE) {
                String newHumidity = Integer.toString(pressureCounter -= 10);

                humidity.setText(newHumidity);

            }

        });

        return btns;
    }

    ImageView getImage(String imgName, int height, int width) {

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imgName;
//        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imgName;
        String imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imgURI));

        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

        return imageView;

    }

    Label getLabel(String text, int top, int right, int bottom, int left) {
        Label label = new Label(text);
        label.setPadding(new Insets(top, right, bottom, left));
        label.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-font:40 Ariel");

        return label;
    }

}
