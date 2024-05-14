//Importing libraries
import javax.swing.JOptionPane;

public class blightedwolfclass {
    public int wolfstrength;
    public int basestrength = 15;
    public int strength;
    public int hitpoints = 20;
    public String message;

    public void wolfencounter(){
        Object[] options = {"attack", "defend"};
        wolfstrength = basestrength;
        message = "A Blighted Wolf attacks you!\nStrength: " + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP ;
        while(hitpoints>0){
            int action = JOptionPane.showOptionDialog(null, message,"Rot and Deceit",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[0]);
            if (action == 0){
                hitpoints = (hitpoints - wolfstrength);
                
                testapp.PHP = (testapp.PHP - wolfstrength);
                message = "you attacked the wolf! \nThe wolf deals you " + wolfstrength + " damage! \nStrength: " + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
            }
            else{
                message = "You guarded! \nThe wolf deals you " + (wolfstrength/2) + " damage! \nStrength: " + wolfstrength + "\nHP: " + hitpoints + "\n Your HP: " + testapp.PHP;
                testapp.PHP = (testapp.PHP - (wolfstrength/2));
            }
        }
        message = "You defeated the wolf!";
        JOptionPane.showMessageDialog(null, message);
    }
}