import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/fullscrn.fxml"));
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();
            stage.setScene(scene);
            stage.show();
            Menu.btn1.setDefaultButton(true);
            root.getChildrenUnmodifiable().addAll(Menu.btn1);
            Menu.btn1.setOnAction(event ->{
                    button1();
                });
            }
    private void button1(){
        System.out.println("click");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
