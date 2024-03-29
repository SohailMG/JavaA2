
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
 * This class contains all layouts and structure that outputs the Humidity
 * control box. using a stack pane as the main container with two VBoxs in first
 * VBox there are three HBoxs for image,number and percentage sign in secondVBox
 * there are two HBoxes for two buttons up and down
 *
 * @author sohailgsais
 */
public class HumidityControl {

    Label temp;
    int humidityCounter = 35;
    final int MAXHUMIDITY = 55;
    final int MINHUMIDITY = 30;

    /**
     * Main container of humidity control box
     *
     * @return stackpane containing border title with box content
     */
    Pane humidityContainer() {
        StackPane content = new StackPane();
        Label title = new Label("Humidity Control");
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        title.setTranslateY(-7);
        title.setTranslateX(10);

        title.setBackground(new Background(
                new BackgroundFill(Color.rgb(101, 67, 33),
                        new CornerRadii(5.0), new Insets(-5.0))));
        title.setTextFill(Color.WHITE);
        content.getChildren().addAll(humidityControlContainer(), title);
        content.setPadding(new Insets(10, 10, 10, 30));

        return content;
    }

    /**
     * Container of two Vboxes VBOX 1 - three HBoxes containing
     * image/label/label VBOX 2 - two buttons UP/DOWN
     *
     * @return container of two VBoxes
     */
    Pane humidityControlContainer() {
        VBox container = new VBox(2);

        container.getChildren().add(humidityControls());
        container.getChildren().add(humidityControlBtns());
        container.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-border-width:2;");
        container.setPadding(new Insets(30, 0, 0, 30));

        return container;
    }

    /**
     * container of three HBoxes HBox 1 - has Humidity icon image HBox 2 -
     * Humidity number label HBox 3 - percent sign label
     *
     * @return
     */
    Pane humidityControls() {
        HBox controls = new HBox(3);

        String tmp = Integer.toString(humidityCounter);
        temp = getLabel(tmp, 10, 10, 10, 10);
        Label tempType = getLabel("%", 10, 10, 10, 10);
        temp.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:50 Ariel");
        tempType.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:20 Ariel");

        temp.setTextFill((javafx.scene.paint.Color.RED));
        tempType.setTextFill((javafx.scene.paint.Color.WHITE));
        controls.getChildren().add(getImage("humidity-icon.png", 50, 50));
        controls.getChildren().add(temp);
        controls.getChildren().add(tempType);

        return controls;
    }

    /**
     * Container of two HBoxes HBox 1 - increment button HBox 2 - decrement
     * button
     *
     * @return
     */
    Pane humidityControlBtns() {
        HBox btns = new HBox(2);

        Button btnUp = new CustomButton("Up", 50, 50);
        btnUp.setGraphic(getImage("up-icon.png", 50, 50));
        btnUp.setPadding(new Insets(10, 20, 10, 0));
        btnUp.setStyle("-fx-border-radius:10;");

        /*
        increment button event handler, when clicked
        checks if the counter is less than the maxhumidity
        if true then counter will increment by 1 and replace the current label
        with the new integer value
         */
        btnUp.setOnAction(e -> {

            if (humidityCounter < MAXHUMIDITY) {
                humidityCounter++;
                String tmp = Integer.toString(humidityCounter);
                temp.setText(tmp);
            }

        });

        Button btnDown = new CustomButton("Down", 50, 50);
        btnDown.setGraphic(getImage("down-icon.png", 50, 50));
        btnDown.setStyle("-fx-border-radius:20;");
        btnDown.setPadding(new Insets(10, 20, 10, 0));
        /*
        decrement button event handler, when clicked
        checks if the counter is more than the maxhumidity
        if true then counter will decrement by 1 and replace the current label
        with the new integer value
         */
        btnDown.setOnAction(e -> {

            if (humidityCounter > MINHUMIDITY) {
                humidityCounter--;
                String tmp = Integer.toString(humidityCounter);
                temp.setText(tmp);
            }

        });
        btns.setPadding(new Insets(10));
        btns.getChildren().add(btnDown);
        btns.getChildren().add(btnUp);

        btns.setSpacing(20);

        return btns;
    }

    /**
     * makes an imageview object for each image being used
     *
     * @param imgName string image file eg 'example.png'
     * @param height height of the image
     * @param width width of the image
     * @return imageview object
     */
    ImageView getImage(String imgName, int height, int width) {

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imgName;
        String imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imgURI));

        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

        return imageView;

    }

    /**
     * creates a label with custom attributes and padding
     *
     * @param text what the label will display
     * @param top top padding
     * @param right right padding
     * @param bottom bottom padding
     * @param left left padding
     * @return label
     */
    Label getLabel(String text, int top, int right, int bottom, int left) {
        Label label = new Label(text);
        label.setPadding(new Insets(top, right, bottom, left));
        label.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-font:40 Ariel");

        return label;
    }

}
