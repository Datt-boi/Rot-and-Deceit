import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class mugger {
    //variable to store the total strength of the Mugger, including items
    public static int muggerstrength;
    //Base strength of the Mugger, with no items
    public static int basestrength = 20;

    public static int itemStrength = 0;
    public static int enemyHP = 100;
    public static String items = "knife";
    public static String message;
    public static String playerAccMsg;
    public static String enemyAccMsg;
    public static int playerAcc = ThreadLocalRandom.current().nextInt(1, 6);
    public static int enemyAcc = ThreadLocalRandom.current().nextInt(1, 6);
    public static Object[] options = { "attack", "guard" };
    public static Object[] lose = {"GAME OVER",};
    public static int guardvalue = 0;

    public static void muggerencounter() {
        //message displayed at start of encounter, one time
        message = "A mugger attacks you with a " + items + "! \nStrength: " + muggerstrength + "\nHP: "
                    + enemyHP
                    + "\n Your HP: " + Stats.playerHP;

        while (enemyHP > 0 && Stats.playerHP > 0) {

            muggerstrength = basestrength;

            //Declaring action variable to store the input of the player inside
            int action = JOptionPane.showOptionDialog(null, message,
                    "Rot and Deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            
            //If the player chose option 0 (attack), this if loop triggers
            if (action == 0) {

                //calculating the accuracy of the player's attack
                int playerAcc = ThreadLocalRandom.current().nextInt(1, 7);

                if (playerAcc > 3 || (playerAcc > 1 && guardvalue == 1)){
                    enemyHP = (enemyHP - Stats.playerStr);
                    playerAccMsg = "And you hit him! The mugger lost " + Stats.playerStr + " HP!";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    playerAccMsg = " But you missed, and dealt no damage!";
                }

                //calculating the accuracy of the enemy's attack and storing it in playerAcc
                int enemyAcc = ThreadLocalRandom.current().nextInt(1, 7);
                //if the accuracy point is greater then 3, triggers this loop
                if (enemyAcc > (3 + (Stats.armourCount))){
                    //subtracts an amount equal to the mugger's strength from the player's hitPoints, then storing the attack result in enemyAccMsg
                    Stats.playerHP = (Stats.playerHP - muggerstrength);
                    enemyAccMsg = "The mugger hits you, dealing you " + muggerstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in playerAccMsg
                    enemyAccMsg = " But he misses, and deals no damage!";
                }
                //message displayed at the end of each attack result, displaying the action the player took, the attack
                //results stored in playerAccMsg and enemyAccMsg, as well as the remaining HP of both the guard and the player
                message = "you attacked the mugger, " + playerAccMsg + "\nThe mugger attacks!"  + enemyAccMsg
                + "\nMugger Strength: " + muggerstrength + "\nMugger HP: " + enemyHP
                + "\n Your HP: " + Stats.playerHP;
                guardvalue = 0;
            } 
            
            //If the remaining action is selected (guard) this loop triggers
            else {
                //calculating the accuracy of the enemy's attack and storing it in enemyAcc
                int enemyAcc = ThreadLocalRandom.current().nextInt(1, 7);
                
                if (enemyAcc > (3 + (Stats.armourCount))){
                    //subtracts an amount equal to the mugger's strength from the player's hitPoints, then storing the attack result in enemyAccMsg
                    Stats.playerHP = (Stats.playerHP - muggerstrength);
                    enemyAccMsg = "and hits you, dealing you " + muggerstrength + " damage.";
                }
                //If the accuracy is not greater then 3, triggers this loop
                else {
                    //Stores the attack result (no damage dealt) in playerAccMsg
                    enemyAccMsg = ",but he misses, and deals no damage!";
                }
                //calculating the sucess of the player's guard
                int playerAcc = ThreadLocalRandom.current().nextInt(1,7);
                if (playerAcc > 2){
                    if (enemyAcc > (3 + (Stats.armourCount))){
                        Stats.playerHP = (Stats.playerHP + muggerstrength);
                        playerAccMsg = "You blocked the mugger's attack sucesfully, negating any damage! \nYour accuracy will also be significantly boosted next turn!";
                        guardvalue = 1;
                    }
                    else{
                        playerAccMsg = "You blocked the mugger's attack sucesfully, negating any damage! \nYour accuracy will also be significantly boosted next turn!";
                        guardvalue = 1;
                    }
                }
                else {
                    playerAccMsg = "You try to block the mugger's attack, but you are unsucessful.";
                }
                message = "You are on guard, preparing to block! \nThe mugger attacks you " + enemyAccMsg + "\n" + playerAccMsg +
                "\nMugger strength: " + muggerstrength + "\nMugger HP: " + enemyHP
                + "\n Your HP: " + Stats.playerHP;
            }
        }
        if (Stats.playerHP > 0){
            message = "You defeated the Mugger! \n It dropped a bandage!";
            JOptionPane.showMessageDialog(null, message);
            inventory.bandages = "Bandages";
            return;
        }
        else {
            message = "The Mugger's experience in robbing innocent people has proven too much for you to face. You can feel your strength slowly fading...";
            JOptionPane.showOptionDialog(null,
                message,
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                System.exit (0);
        }
    }
}
