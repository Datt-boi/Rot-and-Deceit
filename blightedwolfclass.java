
//Importing libraries
import javax.swing.JOptionPane;

public class blightedwolfclass {
    public static int wolfstrength;
    public static int basestrength = 15;
    public static int strength;
    public static int hitpoints = 20;
    public static String message;


    public static void wolfencounter() {
        Object[] options = { "attack", "defend" };
        Object[] lose = { "GAME OVER", };

        wolfstrength = basestrength;
        message = "A Blighted Wolf attacks you!\nStrength: " + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: "
                + App.curPHP;
        while (hitpoints > 0 && App.curPHP > 0){
            int action = JOptionPane.showOptionDialog(null, message, "Rot and Deceit", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            if (action == 0) {
                hitpoints = (hitpoints - wolfstrength);

                App.curPHP = (App.curPHP - wolfstrength);
                message = "you attacked the wolf! \nThe wolf deals you " + wolfstrength + " damage! \nStrength: "
                        + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: " + App.curPHP;
            } else {
                message = "You guarded! \nThe wolf deals you " + (wolfstrength / 2) + " damage! \nStrength: "
                        + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: " + App.curPHP;
                App.curPHP = (App.curPHP - (wolfstrength / 2));
            }
        }
        if (App.curPHP > 0){
            message = "You defeated the wolf!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        else {
            message = "The wolf's relentless onslaught of teeth and claws has proven too much for you to face. You can feel your strength slowly fading...";
            JOptionPane.showOptionDialog(null,
                message,
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                System.exit (0);
        }
    }
}