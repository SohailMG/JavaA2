
import java.io.File;
import java.math.BigDecimal;
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
public class TemperatureControl {

    final double MAXTEMP = 25.5;
    final double MINTEMP = 10.0;
    Label temp;
    int tempCounter = 0;

    Pane tempContainer() {
        StackPane content = new StackPane();

        Label title = new Label("Temperature Control");
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        title.setTranslateY(-7);
        title.setTranslateX(10);
        
        title.setBackground(new Background(new BackgroundFill(Color.rgb(101, 67, 33), new CornerRadii(5.0), new Insets(-5.0))));;
        title.setTextFill(Color.WHITE);

        content.getChildren().addAll(tempControlContainer(),title);
        content.setPadding(new Insets(10, 10, 10, 30));

        return content;
    }

    Pane tempControlContainer() {
        VBox container = new VBox(2);

        container.getChildren().add(tempControls());
        container.getChildren().add(tempControlsbtns());
        container.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-border-width:2;");
        container.setPadding(new Insets(30, 0, 0, 30));

        return container;
    }

    Pane tempControls() {
        HBox controls = new HBox(3);

        temp = getLabel("15.4", 10, 10, 10, 10);
        Label tempType = getLabel("°C", 10, 10, 10, 10);
        temp.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:50 Ariel");
        temp.setTextFill(javafx.scene.paint.Color.RED);
        tempType.setTextFill(javafx.scene.paint.Color.WHITE);
        tempType.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:20 Ariel");

        controls.getChildren().add(getImage("thermometer-icon.png", 50, 50));
        controls.getChildren().add(temp);
        controls.getChildren().add(tempType);

        return controls;
    }

    Pane tempControlsbtns() {
        HBox btns = new HBox(2);

        Button btnUp = new CustomButton("Up", 50, 50);
        btnUp.setGraphic(getImage("up-icon.png", 50, 50));
        btnUp.setPadding(new Insets(10, 20, 10, 0));
        btnUp.setStyle("-fx-border-radius:10;");

        Button btnDown = new CustomButton("Down", 50, 50);
        btnDown.setGraphic(getImage("down-icon.png", 50, 50));
        btnDown.setPadding(new Insets(10, 20, 10, 0));
        btnDown.setStyle("-fx-border-radius:10;");

        btnUp.setOnAction(e -> {
            Double currentTemp = Double.parseDouble(temp.getText());
            String newTemp = Double.toString(currentTemp);

            currentTemp += 0.1;
            BigDecimal bd = new BigDecimal(currentTemp);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            currentTemp = bd.doubleValue();

            if (currentTemp <= MAXTEMP && currentTemp >= MINTEMP) {
                temp.setText("" + currentTemp);
                tempCounter += 0.1;
            }

        });

        btnDown.setOnAction(e -> {
            Double currentTemp = Double.parseDouble(temp.getText());
            String newTemp = Double.toString(currentTemp);

            currentTemp -= 0.1;
            BigDecimal bd = new BigDecimal(currentTemp);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            currentTemp = bd.doubleValue();

            if (currentTemp >= MINTEMP) {
                temp.setText("" + currentTemp);

            }

        });
        btns.setPadding(new Insets(10));
        btns.getChildren().add(btnDown);
        btns.getChildren().add(btnUp);

        btns.setSpacing(20);

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
