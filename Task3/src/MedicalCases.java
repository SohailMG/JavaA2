
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
public class MedicalCases {

    // MEDICAL CASES
    Pane medicalCasesContainer() {
        HBox container = new HBox();
        StackPane titleContainer = new StackPane();

        Label title = new Label("Medical Cases");
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        title.setTranslateY(-7);
        title.setTranslateX(10);
        
        title.setBackground(new Background(new BackgroundFill(Color.rgb(101, 67, 33), new CornerRadii(5.0), new Insets(-5.0))));;
        title.setTextFill(Color.WHITE);
        titleContainer.getChildren().addAll(medicalCases(),title);
        container.getChildren().add(titleContainer);
        container.setPadding(new Insets(0, 0, 0, 30));
        

        return container;

    }

    Pane medicalCases() {
        StackPane stackpane = new StackPane();
        StackPane stackpane2 = new StackPane();
        StackPane stackpane3 = new StackPane();
        StackPane stackpane4 = new StackPane();
        StackPane stackpane5 = new StackPane();
        HBox boxes = new HBox(5);
        HBox boxTitles = new HBox(5);
        VBox cases = new VBox();

        StackPane[] stacks = {stackpane, stackpane2, stackpane3, stackpane4, stackpane5};
        String[] labels = {"Low", "High", "Norm", "Norm", "High"};
        String[] titles = {"O2", "N20", "AIR1", "CO2", "VAC"};

        for (int i = 0; i < stacks.length; i++) {
            Rectangle square = new Rectangle(50, 50);
            stacks[i].getChildren().addAll(square, new Label(labels[i]));

            boxes.getChildren().add(stacks[i]);
            Label boxTitle = new Label(titles[i]);
            boxTitles.getChildren().add(boxTitle);
            boxTitle.setPadding(new Insets(30, 10, 10, 10));
            boxTitle.setTextFill(Color.YELLOW);
            if (i == 1 || i == 2) {
                square.setFill(Color.AQUA);

            } else {
                square.setFill(Color.ORANGERED);
            }

        }
        boxTitles.setPadding(new Insets(0, 20, 0, 20));
        boxTitles.setSpacing(10);
        boxes.setPadding(new Insets(0, 20, 0, 20));

        cases.getChildren().add(boxTitles);
        cases.setStyle("-fx-border-color: white;" + "-fx-border-radius:8;" + "-fx-border-width:2;");
        cases.getChildren().add(boxes);
        cases.setPadding(new Insets(10, 30, 10, 40));

        return cases;
    }

    Label getLabel(String text, int top, int right, int bottom, int left) {
        Label label = new Label(text);
        label.setPadding(new Insets(top, right, bottom, left));
        label.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-font:40 Ariel");

        return label;
    }

}
