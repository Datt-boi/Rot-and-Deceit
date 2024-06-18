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

public class Menu extends Application {

    @FXML
    public static Button but1 = new Button("continue");

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("fullscrn.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
        stage.setScene(scene);
        stage.show();

        app.app()
        }

    public static void main(String[] args) {
        launch(args);
    }
}