import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    public void start(Stage stage) throws IOException{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fullscrn.fxml"));
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();
            stage.setScene(scene);
            stage.show();
            Menu.but1.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent arg0) {
                    System.out.println("poopy");
                }  
            

    } catch(Exception e) {
        e.printStackTrace();
    }

        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
