import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @FXML
    public static Button but1 = new Button("continue");

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        SampleController sc = new SampleController();
        fxmlLoader.setController(sc);
        fxmlLoader.setLocation(getClass().getResource("fullscrn.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
        stage.setScene(scene);
        stage.show();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("sigma");
            };
        };
        SampleController.but1.setOnAction(event);

    }

    public static void main(String[] args) {
        launch(args);
    }
}