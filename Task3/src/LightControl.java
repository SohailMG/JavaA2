
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
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sohailgsais
 */
public class LightControl {

    int lightsCounter;
    int[] redGreenChanges = {102, 153, 204, 255, 255, 255};
    int[] blueChanges = {0, 0, 0, 0, 153, 204};

    Pane lightControlContainer() {
        VBox lightsContainer = new VBox(3);
        HBox container = new HBox();
        HBox lights1 = new HBox(3);
        HBox lights2 = new HBox(3);
        HBox lights3 = new HBox(3);

        StackPane titleContainer = new StackPane();

        Label title = new Label("Light Control");
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        title.setTranslateY(-7);
        title.setTranslateX(10);
        
        title.setBackground(new Background(new BackgroundFill(Color.rgb(101, 67, 33), new CornerRadii(5.0), new Insets(-5.0))));;
        title.setTextFill(Color.WHITE);
        titleContainer.getChildren().addAll(lightsContainer, title);
        container.getChildren().add(titleContainer);

        CustomButton incBtn = new CustomButton("+", 40, 40);//btn
        lights1.getChildren().add(incBtn);
        lights1.getChildren().add(controlLights());            //lights
        CustomButton decBtn = new CustomButton("-", 40, 40);
        lights1.getChildren().add(decBtn);

        //btn
        CustomButton incBtn2 = new CustomButton("+", 40, 40);//btn
        lights2.getChildren().add(incBtn2);
        lights2.getChildren().add(controlLights());            //lights
        CustomButton decBtn2 = new CustomButton("-", 40, 40);
        lights2.getChildren().add(decBtn2);

        //btn
        CustomButton incBtn3 = new CustomButton("+", 40, 40);//btn
        lights3.getChildren().add(incBtn3);
        lights3.getChildren().add(controlLights());            //lights
        CustomButton decBtn3 = new CustomButton("-", 40, 40);
        lights3.getChildren().add(decBtn3);                  //btn

        CustomButton[] btns = {incBtn, incBtn2, incBtn3, decBtn3, decBtn2, decBtn};
        for (CustomButton btn : btns) {
            btn.setStyle("-fx-text-fill: white;"
                    + "-fx-border-color:  white;"
                    + "-fx-border-width: 2px;"
                    + "-fx-border-radius: 5;"
                    + "-fx-background-color: transparent;"
                    + "-fx-cursor: hand;");

        }

        lightsContainer.getChildren().add(lights1);
        lightsContainer.getChildren().add(lights2);
        lightsContainer.getChildren().add(lights3);

        incBtn.setOnAction((event) -> {
            lightsCounter = 0;
            increasLights(incBtn, lights1);
        });
        decreaseLights(decBtn, lights1);

        incBtn2.setOnAction((event) -> {
            lightsCounter = 0;
            increasLights(incBtn2, lights2);

        });
        decreaseLights(decBtn2, lights2);

        incBtn3.setOnAction((event) -> {
            lightsCounter = 0;
            increasLights(incBtn3, lights3);
        });
        decreaseLights(decBtn3, lights3);

        lightsContainer.setStyle("-fx-border-color: white;" + "-fx-border-radius:8;" + "-fx-border-width:2;");
        lightsContainer.setPadding(new Insets(30, 30, 20, 30));

        return titleContainer;

    }

    Pane controlLights() {
        HBox lights1 = new HBox(6);
        HBox lightsContainer = new HBox();

        final int MAXLIGHTS = 6;

        for (int i = 0; i < MAXLIGHTS; i++) {
            Rectangle rectangle = new Rectangle(40, 20);
            lights1.getChildren().add(rectangle);
            rectangle.setFill(Color.rgb(40, 40, 0));
        }

        lightsContainer.getChildren().add(lights1);
        lightsContainer.setPadding(new Insets(10, 0, 10, 0));

        return lightsContainer;

    }

    ImageView getImage(String imgName, int height, int width) {

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imgName;
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

    public void increasLights(Button btn, HBox lights) {
        btn.setOnAction((event) -> {

            if (lightsCounter < 6) {

                HBox mainWrapper = (HBox) lights.getChildren().get(1);
                HBox lightsWrapper = (HBox) mainWrapper.getChildren().get(0);
                Rectangle currentLight = (Rectangle) lightsWrapper.getChildren().get(lightsCounter);

                currentLight.setFill(Color.rgb(
                        redGreenChanges[lightsCounter],
                        redGreenChanges[lightsCounter],
                        blueChanges[lightsCounter]));
                lightsCounter++;

            }
        });

    }

    public void decreaseLights(Button btn, HBox lights) {
        btn.setOnAction((event) -> {

            if (lightsCounter >= 0) {

                HBox mainWrapper = (HBox) lights.getChildren().get(1);
                HBox lightsWrapper = (HBox) mainWrapper.getChildren().get(0);
                Rectangle currentLight = (Rectangle) lightsWrapper.getChildren().get(lightsCounter);
                --lightsCounter;
                
                currentLight.setFill(Color.rgb(40, 40, 0));
            }

        });

    }

}
