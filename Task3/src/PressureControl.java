

import java.io.File;
import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author sohailgsais
 */
public class PressureControl {
    
    

    // RIGHT
    Pane pressureContainer() {
        StackPane content = new StackPane();
        content.getChildren().add(pressureControlContainer());
        content.setPadding(new Insets(10, 10, 10, 30));

        return content;
    }

    Pane pressureControlContainer() {
        VBox container = new VBox(2);

        container.getChildren().add(pressureControls());
        container.getChildren().add(pressureControlBtns());
        container.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-border-width:2;");
        container.setPadding(new Insets(10, 0, 0, 30));

        return container;
    }

    Pane pressureControls() {
        HBox controls = new HBox(3);

        Label temp = getLabel("54", 10, 10, 10, 10);
        Label tempType = getLabel("kPa", 10, 10, 10, 10);
        temp.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:30 Ariel");
        tempType.setStyle("-fx-border-color: none;" + "-fx-border-radius:0;"
                + "-fx-font:15 Ariel");

        controls.getChildren().add(getImage("pressure-icon.png", 50, 50));
        controls.getChildren().add(temp);
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
        btns.getChildren().add(btnUp);
        btns.getChildren().add(btnDown);

        btns.setSpacing(20);

        return btns;
    }

    ImageView getImage(String imgName, int height, int width) {

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imgName;
//        String imgPath = "/Users/sohailgsais/CST2110 OOP/AssignmentDownload/Task3/images/" + imgName;
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
