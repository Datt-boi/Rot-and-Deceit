
//Importing libraries
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class blightedwolfclass {
    public static int wolfstrength;
    public static int basestrength = 10;
    public static int strength;
    public static int hitpoints = 20;
    public static String message;
    public static String Paccmessage;
    public static String Eaccmessage;
    public static int Paccuracy = ThreadLocalRandom.current().nextInt(1, 6);
    public static int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 6);
    public static Object[] options = { "attack", "guard" };
    public static Object[] lose = {"GAME OVER",};
    public static int guardvalue = 0;


    public static void wolfencounter() {
        wolfstrength = basestrength;
        message = "A Blighted Wolf attacks you!\nStrength: " + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: "
                + App.curPHP;
        while (hitpoints > 0 && App.curPHP > 0){
            int action = JOptionPane.showOptionDialog(null, message, "Rot and Deceit", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            if (action == 0) {
                //calculating the accuracy of the player's attack and storing it in Paccuracy
                int Paccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Paccuracy > 3 || (Paccuracy > 1 && guardvalue == 1)){
                    //subtracts an amount equal to the player's strength from the wolf's hitpoints, then storing the attack result in Paccmessage
                    hitpoints = (hitpoints - App.maxstr);
                    Paccmessage = "And you hit it! The wolf lost " + App.maxstr + " HP!";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in Paccmessage
                    Paccmessage = " But you missed, and dealt no damage!";
                }

                //calculating the accuracy of the enemy's attack and storing it in Paccuracy
                int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Eaccuracy > 2){
                    //subtracts an amount equal to the wolf's strength from the player's hitpoints, then storing the attack result in Eaccmessage
                    App.curPHP = (App.curPHP - wolfstrength);
                    Eaccmessage = "The wolf hits you, dealing you " + wolfstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in Eaccmessage
                    Eaccmessage = " But it misses, and deals no damage!";
                }
                message = "you attacked the wolf, " + Paccmessage + "\nThe wolf attacks!"  + Eaccmessage
                + "\nWolf Strength: " + wolfstrength + "\nWolf HP: " + hitpoints
                + "\n Your HP: " + App.curPHP;
                guardvalue = 0;
            } 
            
            else {
                //calculating the accuracy of the enemy's attack and storing it in Paccuracy
                int Eaccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Eaccuracy > 3){
                    //subtracts an amount equal to the wolf's strength from the player's hitpoints, then storing the attack result in Eaccmessage
                    App.curPHP = (App.curPHP - wolfstrength);
                    Eaccmessage = "and hits you, dealing you " + wolfstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in Paccmessage
                    Eaccmessage = ",but it misses, and deals no damage!";
                }
                //calculating the sucess of the player's guard
                int Paccuracy = ThreadLocalRandom.current().nextInt(1,7);
                if (Paccuracy > 2){
                    App.curPHP = (App.curPHP + wolfstrength);
                    Paccmessage = "You blocked the wolf's attack sucesfully, negating any damage! \nYour accuracy will also be significantly boosted next turn!";
                    guardvalue = 1;
                }
                else {
                    Paccmessage = "You try to block the wolf's attack, but you are unsucessful.";
                }
                message = "You are on guard, preparing to block! \nThe guard attacks you " + Eaccmessage + "\n" + Paccmessage +
                "\nWolf strength: " + wolfstrength + "\nWolf HP: " + hitpoints
                + "\n Your HP: " + App.curPHP;
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