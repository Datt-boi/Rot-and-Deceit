
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
    public static int guardvalue = 0;

    public static void guardencounter() {
        //message displayed at start of encounter, one time
        message = "A guard attacks you with a " + items + "! \nStrength: " + guardstrength + "\nHP: "
                    + hitpoints
                    + "\n Your HP: " + App.curPHP;

        //while loop that will continue to trigger as long as neither the player's or the enemy's HP is below 0
        while (hitpoints > 0 && App.curPHP > 0) {

            //calculating total strength of the guard using its base strength plus item strength
            guardstrength = basestrength;

            //Declaring action variable to store the input of the player inside
            int action = JOptionPane.showOptionDialog(null, message,
                    "Rot and Deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            
            //If the player chose option 0 (attack), this if loop triggers
            if (action == 0) {

                //calculating the accuracy of the player's attack and storing it in Paccuracy
                int Paccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Paccuracy > 3 || (Paccuracy > 1 && guardvalue == 1)){
                    //subtracts an amount equal to the player's strength from the guard's hitpoints, then storing the attack result in Paccmessage
                    hitpoints = (hitpoints - App.maxstr);
                    Paccmessage = "And you hit him! The guard lost " + App.maxstr + " HP!";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in Paccmessage
                    Paccmessage = " But you missed, and dealt no damage!";
                }

                //calculating the accuracy of the enemy's attack and storing it in Paccuracy
                int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Eaccuracy > 3){
                    //subtracts an amount equal to the guard's strength from the player's hitpoints, then storing the attack result in Eaccmessage
                    App.curPHP = (App.curPHP - guardstrength);
                    Eaccmessage = "The guard hits you, dealing you " + guardstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in Paccmessage
                    Eaccmessage = " But he misses, and deals no damage!";
                }
                //message displayed at the end of each attack result, displaying the action the player took, the attack
                //results stored in Paccmessage and Eaccmessage, as well as the remaining HP of both the guard and the player
                message = "you attacked the guard, " + Paccmessage + "\nThe guard attacks!"  + Eaccmessage
                + "\nGuard Strength: " + guardstrength + "\nGuard HP: " + hitpoints
                + "\n Your HP: " + App.curPHP;
                guardvalue = 0;
            } 
            
            //If the remaining action is selected (guard) this loop triggers
            else {
                //calculating the accuracy of the enemy's attack and storing it in Paccuracy
                int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Eaccuracy > 3){
                    //subtracts an amount equal to the guard's strength from the player's hitpoints, then storing the attack result in Eaccmessage
                    App.curPHP = (App.curPHP - guardstrength);
                    Eaccmessage = "and hits you, dealing you " + guardstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in Paccmessage
                    Eaccmessage = ",but he misses, and deals no damage!";
                }
                //calculating the sucess of the player's guard
                int Paccuracy = ThreadLocalRandom.current().nextInt(1,7);
                if (Paccuracy > 2){
                    App.curPHP = (App.curPHP + guardstrength);
                    Paccmessage = "You blocked the guard's attack sucesfully, negating any damage! Your accuracy will also be significantly boosted next turn!";
                    guardvalue = 1;
                }
                else {
                    Paccmessage = "You try to block the guard's attack, but you are unsucessful.";
                }
                message = "You are on guard, preparing to block! \nThe guard attacks you " + Eaccmessage + "\n" + Paccmessage +
                "\nGuard strength: " + guardstrength + "\nGuard HP: " + hitpoints
                + "\n Your HP: " + App.curPHP;
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