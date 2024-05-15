import javax.swing.JOptionPane;

public class deceitfulmanclass {
    //list of variables
    public int dmanstrength;
    public int basestrength = 10;
    public int strength;
    public int itemstrength = 40;
    public int hitpoints = 250;
    public String items = "zweihander";
    public String message;
    

    public void dmanencounter(){
        //list of buttons. Separate buttons separated by a comma.
        Object[] options = {"attack", "guard"};
        
        //calculating the total strength of the deceitful man by adding his base strength with the item's strength
        dmanstrength = basestrength + itemstrength;
        //displaying the encounter message
        message = "The Deceitful Man attacks you with a " + items + "! \nStrength: " + dmanstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP ;
        //while loop that will stop the encounter as soon as the enemy runs out of HP
        while (hitpoints>0){
            //
            int action = JOptionPane.showOptionDialog(null, message,"Rot and Deceit",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            //If the player chooses to attack, this code will trigger
            if (action == 0){
                //subtracting the players attack strength from the enemy's HP
                hitpoints = (hitpoints - testapp.Pbasestrength);
                
                //subtracting the enemy's strength from the player's HP
                testapp.PHP = (testapp.PHP - dmanstrength);
                //displaying the results of these attacks to the player
                message = "you attacked the guard! \nThe guard deals you " + dmanstrength + " damage with his spear! \nStrength: " + dmanstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
            }
            //If the player chooses not to attack(to guard), this code triggers
            else{
                
                message = "You guarded! \nThe guard deals you " + (dmanstrength/2) + " damage with his spear! \nStrength: " + dmanstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
                testapp.PHP = (testapp.PHP - (dmanstrength/2));
            }
        }
    }
}
