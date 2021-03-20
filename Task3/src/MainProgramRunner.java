
import java.nio.file.Paths;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sohailgsais
 */
public class MainProgramRunner extends Application {

    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'"); 

        Scene scene = new Scene(getBorderPane(), 870, 600, Color.BURLYWOOD);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);
        primaryStage.sizeToScene();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    Pane getStackPane() {
        StackPane pane = new StackPane();

        return pane;
    }

    Label getLabel(String text, int top, int right, int bottom, int left) {
        Label label = new Label(text);
        label.setPadding(new Insets(top, right, bottom, left));
        label.setStyle("-fx-border-color: white;" + "-fx-border-radius:10;" + "-fx-font:40 Ariel");

        return label;
    }

    TopContainer topContainer = new TopContainer();
    TemperatureControl tempControl = new TemperatureControl();
    PressureControl pressureControl = new PressureControl();
    HumidityControl humidityControl = new HumidityControl();
    LightControl lightsControl = new LightControl();
    MedicalCases medicalCases = new MedicalCases();
    Pane getBorderPane() {
        BorderPane bPane = new BorderPane();
        bPane.setBackground(new Background(new BackgroundFill(Color.valueOf("rgb(101,67,33)"), new CornerRadii(0), Insets.EMPTY)));

        //Setting the top, bottom, center, right and left nodes to the pane 
        bPane.setTop(topContainer.topSection());
        bPane.setBottom(bottomContainer());
        bPane.setLeft(tempControl.tempContainer());
        bPane.setRight(pressureControl.pressureContainer());
        bPane.setCenter(humidityControl.humidityContainer());

        return bPane;
    }

    Pane bottomContainer() {
        HBox container = new HBox(2);
        container.getChildren().add(lightsControl.lightControlContainer());
        container.getChildren().add(medicalCases.medicalCasesContainer());
        container.setPadding(new Insets(10, 25, 10, 25));

        return container;
    }



}
