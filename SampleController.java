
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

public class SampleController {

<<<<<<< Updated upstream
=======
    int choose = 10000;

>>>>>>> Stashed changes
    @FXML
    public static Button but1;

    @FXML
    private void cont() {
<<<<<<< Updated upstream
        System.out.println("penis");
=======
       App.choice=1;
       System.out.println("hehe");
       dialouge.setText(App.story);
       
>>>>>>> Stashed changes
    }

    @FXML
    private Button but2;

    @FXML
<<<<<<< Updated upstream
    private void inv() {
        System.out.println("balls");
=======
    private void inv() throws Exception {
        inventory.tron();
        System.out.println("gigaballs");
        dialouge.setText(App.story);
>>>>>>> Stashed changes
    }

    @FXML
    private Button butext;

    @FXML
    private void choice() {
<<<<<<< Updated upstream
        System.out.println("Nutz");
=======
        App.choice=3;
        System.out.println("fuck");
        dialouge.setText(App.story);
         
        
>>>>>>> Stashed changes
    }

    @FXML
    private Button butinv;

    @FXML
    private void plop() {
<<<<<<< Updated upstream
        System.out.println("Shaft");
    }

    @FXML
    private DialogPane dialouge;
=======
        App.choice=2;
        dialouge.setText(App.story);
        System.out.println("Shaft");
    }

  @FXML 
   public Label dialouge;   


>>>>>>> Stashed changes

    @FXML
    private AnchorPane plop;
}
