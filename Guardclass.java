//Importing libraries
import javax.swing.JOptionPane;

public class Guardclass {
    private int basestrength = 10;
    private int strength;
    private int itemstrength;
    private int hitpoints = 20;
    private String items = "spear";
    public String message;
    
    public guardstrength(int strength){
        this.strength = basestrength + itemstrength;
    }

    public void guardencounter(){
        message = "A guard attacks you!";

        JOptionPane.showOptionDialog(null, message, items, strength, basestrength, null, null, basestrength, )
    }

}
