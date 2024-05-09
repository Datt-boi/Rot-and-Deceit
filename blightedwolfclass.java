//Importing libraries
import javax.swing.JOptionPane;

public class blightedwolfclass {
    public int wolfstrength;
    public int basestrength = 15;
    public int strength;
    public int hitpoints = 20;
    public String message;

    public void wolfencounter(){
        wolfstrength = basestrength;
        message = "A Blighted Wolf attacks you!\nStrength: " + wolfstrength + "\nHP: " + hitpoints ;

        JOptionPane.showConfirmDialog(null, message);
    }

}
