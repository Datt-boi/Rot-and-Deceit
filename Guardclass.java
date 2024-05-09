//Importing libraries
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Guardclass {
    private static final String JButton = null;
    public int guardstrength;
    public int basestrength = 10;
    public int strength;
    public int itemstrength = 0;
    public int hitpoints = 20;
    public String items = "spear";
    public String message;
    

    public void guardencounter(){
        guardstrength = basestrength + itemstrength;
        message = "A guard attacks you with a " + items + "! \nStrength: " + guardstrength + "\nHP: " + hitpoints ;

        JOptionPane.showMessageDialog(null, message);
    }

}
