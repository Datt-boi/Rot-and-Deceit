
import javafx.application.Application;
import javafx.stage.Stage;

public class App {
        static int time = 0;
        static String story = new String("null");
        static int choice = 0;

        static void game() {
                // These are our actions currently. every one of them has to be an object. not
                // ideal.
                // while loop is here so that if player dies, the game ends.
                while (choice ==0){
                        story = "You awaken in the pitch darkness of your cell,\n a familiar smell of dried blood and rotting corpses stains your nose.\n How long has it been? Weeks? Years?\n You have no understanding of time anymore.";
                }
                choice = 0;
                while (choice == 0) {
                        story= "piss";
                }

        }
}