

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sohailgsais
 */
public class MainProgramRunner extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getBorderPane(), 880, 600);

        primaryStage.setTitle("SURGERY SYSTEM");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    // creating class objects for each section of UI
    TopContainer topContainer = new TopContainer();
    LightControl lightsControl = new LightControl();
    MedicalCases medicalCases = new MedicalCases();
    TemperatureControl tempControl = new TemperatureControl();
    PressureControl pressureControl = new PressureControl();
    HumidityControl humidityControl = new HumidityControl();

    // main layout container
    Pane getBorderPane() {
        BorderPane bPane = new BorderPane();
        bPane.setBackground(
                new Background(
                        new BackgroundFill(Color.valueOf("rgb(101,67,33)"),
                                new CornerRadii(0), Insets.EMPTY)));

        //Setting the top, bottom, center, right and left nodes to the pane 
        bPane.setTop(topContainer.topSection());
        bPane.setBottom(bottomContainer());
        bPane.setLeft(tempControl.tempContainer());
        bPane.setRight(pressureControl.pressureContainer());
        bPane.setCenter(humidityControl.humidityContainer());

        return bPane;
    }

    // container of the bottom section of the UI
    Pane bottomContainer() {
        HBox container = new HBox(2);
        container.getChildren().add(lightsControl.lightControlContainer());
        container.getChildren().add(medicalCases.medicalCasesContainer());
        container.setPadding(new Insets(10, 0, 10, 25));

        return container;
    }

}
