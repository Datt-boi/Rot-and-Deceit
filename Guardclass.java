//Importing libraries
import javax.swing.JOptionPane;

public class Guardclass {
    public int guardstrength;
    public int basestrength = 10;
    public int strength;
    public int itemstrength = 0;
    public int hitpoints = 30;
    public String items = "spear";
    public String message;

    public void guardencounter(){
        Object[] options = {"attack", "guard"};

        guardstrength = basestrength + itemstrength;
        message = "A guard attacks you with a " + items + "! \nStrength: " + guardstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
        while (hitpoints>0){
            int action = JOptionPane.showOptionDialog(null, message,
                "Rot and Deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (action == 0){
                    hitpoints = (hitpoints - guardstrength);
                    
                    testapp.PHP = (testapp.PHP - guardstrength);
                    message = "you attacked the guard! \nThe guard deals you " + guardstrength + " damage with his spear! \nStrength: " + guardstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
                }
                else{
                    message = "You guarded! \nThe guard deals you " + (guardstrength/2) + " damage with his spear! \nStrength: " + guardstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
                    testapp.PHP = (testapp.PHP - (guardstrength/2));
                }
        }
        message = "You defeated the guard! \n It dropped the spear!";
        JOptionPane.showMessageDialog(null, message);
    }
}
