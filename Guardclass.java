
//Importing libraries
import javax.swing.JOptionPane;

public class Guardclass {
    public static int guardstrength;
    public static int basestrength = 10;
    public static int strength;
    public static int itemstrength = 0;
    public static int hitpoints = 30;
    public static String items = "spear";
    public static String message;
    public static Object[] bozo = { "GAME OVER", };

    public static void guardencounter() {
        while (App.curPHP > 0) {
            Object[] options = { "attack", "guard" };

            while (hitpoints > 0) {
                guardstrength = App.maxstr;
                message = "A guard attacks you with a " + items + "! \nStrength: " + guardstrength + "\nHP: "
                        + hitpoints
                        + "\n Your HP: " + App.curPHP;

                int action = JOptionPane.showOptionDialog(null, message,
                        "Rot and Deceit",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (action == 0) {
                    hitpoints = (hitpoints - guardstrength);

                    App.curPHP = (App.curPHP - guardstrength);
                    message = "you attacked the guard! \nThe guard deals you " + guardstrength
                            + " damage with his spear! \nStrength: " + guardstrength + "\nHP: " + hitpoints
                            + "\n Your HP: " + App.curPHP;
                } else {
                    message = "You guarded! \nThe guard deals you " + (guardstrength / 2)
                            + " damage with his spear! \nStrength: " + guardstrength + "\nHP: " + hitpoints
                            + "\n Your HP: " + App.curPHP;
                    App.curPHP = (App.curPHP - (guardstrength / 2));
                }
            }
            message = "You defeated the guard! \n It dropped the spear!";
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        JOptionPane.showOptionDialog(null,
                "You suddenly begin to feel your body growing weak. \n The light in your eyes begins to leave, and you collapse to the ground, \n your life cut short.",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, bozo, bozo[0]);
    }
}
