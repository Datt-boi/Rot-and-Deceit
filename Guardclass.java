
//Importing libraries
import javax.swing.JOptionPane;
import java.util.concurrent.ThreadLocalRandom;

public class Guardclass {
    //variable to store the total strength of the guard, including items
    public static int guardstrength;
    //Base strength of the guard, with no items
    public static int basestrength = 10;

    public static int itemstrength = 0;
    public static int hitpoints = 30;
    public static String items = "spear";
    public static String message;
    public static String Paccmessage;
    public static String Eaccmessage;
    public static int Paccuracy = ThreadLocalRandom.current().nextInt(1, 6);
    public static int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 6);
    public static Object[] options = { "attack", "guard" };
    public static Object[] lose = {"GAME OVER",};

    public static void guardencounter() {
        message = "A guard attacks you with a " + items + "! \nStrength: " + guardstrength + "\nHP: "
                    + hitpoints
                    + "\n Your HP: " + App.curPHP;
        while (hitpoints > 0 && App.curPHP > 0) {
            guardstrength = basestrength;
            int action = JOptionPane.showOptionDialog(null, message,
                    "Rot and Deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (action == 0) {
                int Paccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                if (Paccuracy < 3){
                    hitpoints = (hitpoints - App.maxstr);
                    Paccmessage = "And you hit him! The guard lost " + App.maxstr + " HP!";
                }
                else {
                    Paccmessage = " But you missed, and dealt no damage!";
                }
                int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                if (Eaccuracy < 3){
                    App.curPHP = (App.curPHP - guardstrength);
                    Eaccmessage = "The guard hits you, dealing you " + guardstrength + " damage.";
                }
                else {
                    Eaccmessage = "But he misses, and deals no damage!";
                }
                message = "you attacked the guard, " + Paccmessage + "\nThe guard attacks!"  + Eaccmessage
                + "\nGuard Strength: " + guardstrength + "\nGuard HP: " + hitpoints
                    + "\n Your HP: " + App.curPHP;
            } 
                
            else {
                message = "You guarded! \nThe guard deals you " + (guardstrength / 2)
                    + " damage with his spear! \nStrength: " + guardstrength + "\nHP: " + hitpoints
                    + "\n Your HP: " + App.curPHP;
                App.curPHP = (App.curPHP - (guardstrength / 2));
            }
        }
        if (App.curPHP > 0){
            message = "You defeated the guard! \n It dropped the spear!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        else {
            message = "The guard's mastery of the art of sparring has proven too much for you to face. You can feel your strength slowly fading...";
            JOptionPane.showOptionDialog(null,
                message,
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                System.exit (0);
        }
    }
}
