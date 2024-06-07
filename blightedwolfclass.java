
//Importing libraries
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class blightedwolfclass {
    public static int wolfstrength;
    public static int basestrength = 10;
    public static int strength;
    public static int enemyHP = 20;
    public static String message;
    public static String playerAccMsg;
    public static String enemyAccMsg;
    public static int playerAcc = ThreadLocalRandom.current().nextInt(1, 6);
    public static int enemyAcc = ThreadLocalRandom.current().nextInt(1, 6);
    public static Object[] options = { "attack", "guard" };
    public static Object[] lose = {"GAME OVER",};
    public static int guardvalue = 0;


    public static void wolfencounter() {
        wolfstrength = basestrength;
        message = "A Blighted Wolf attacks you!\nStrength: " + wolfstrength + "\nHP: " + enemyHP + "\n Your HP: "
                + Stats.playerHP;
        while (enemyHP > 0 && Stats.playerHP > 0){
            int action = JOptionPane.showOptionDialog(null, message, "Rot and Deceit", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            if (action == 0) {
                //calculating the accuracy of the player's attack and storing it in Paccuracy
                int Paccuracy = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (Paccuracy > 3 || (Paccuracy > 1 && guardvalue == 1)){
                    //subtracts an amount equal to the player's strength from the wolf's enemyHP, then storing the attack result in playerAccMsg
                    enemyHP = (enemyHP - Stats.playerStr);
                    playerAccMsg = "And you hit it! The wolf lost " + Stats.playerStr + " HP!";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in playerAccMsg
                    playerAccMsg = " But you missed, and dealt no damage!";
                }

                //calculating the accuracy of the enemy's attack and storing it in Paccuracy
                int enemyAcc = ThreadLocalRandom.current().nextInt(1, 7);

                if (enemyAcc > (2 + (Stats.armourCount))){
                    Stats.playerHP = (Stats.playerHP - wolfstrength);
                    enemyAccMsg = "The wolf hits you, dealing you " + wolfstrength + " damage.";
                }
                else {
                    //Stores the attack result (no damage dealt) in enemyAccMsg
                    enemyAccMsg = " But it misses, and deals no damage!";
                }
                message = "you attacked the wolf, " + playerAccMsg + "\nThe wolf attacks!"  + enemyAccMsg
                + "\nWolf Strength: " + wolfstrength + "\nWolf HP: " + enemyHP
                + "\n Your HP: " + Stats.playerHP;
                guardvalue = 0;
            } 
            
            else {
                //calculating the accuracy of the enemy's attack and storing it in Paccuracy
                int enemyAcc = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (enemyAcc > (3 + (Stats.armourCount))){
                    //subtracts an amount equal to the wolf's strength from the player's enemyHP, then storing the attack result in enemyAccMsg
                    Stats.playerHP = (Stats.playerHP - wolfstrength);
                    enemyAccMsg = "and hits you, dealing you " + wolfstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in playerAccMsg
                    enemyAccMsg = ",but it misses, and deals no damage!";
                }
                //calculating the sucess of the player's guard
                int Paccuracy = ThreadLocalRandom.current().nextInt(1,7);
                if (Paccuracy > 2){
                    if (enemyAcc > (2 + (Stats.armourCount))){
                        Stats.playerHP = (Stats.playerHP + wolfstrength);
                        playerAccMsg = "You blocked the wolf's attack sucesfully, negating any damage! \nYour accuracy will also be significantly boosted next turn!";
                        guardvalue = 1;
                    }
                    else{
                        playerAccMsg = "You blocked the wolf's attack sucesfully, negating any damage! \nYour accuracy will also be significantly boosted next turn!";
                        guardvalue = 1;
                    }
                }
                else {
                    playerAccMsg = "You try to block the wolf's attack, but you are unsucessful.";
                }
                message = "You are on guard, preparing to block! \nThe wolf attacks you " + enemyAccMsg + "\n" + playerAccMsg +
                "\nWolf strength: " + wolfstrength + "\nWolf HP: " + enemyHP
                + "\n Your HP: " + Stats.playerHP;
            }
        }
        if (Stats.playerHP > 0){
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