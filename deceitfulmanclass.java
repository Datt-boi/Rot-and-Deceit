import javax.swing.JOptionPane;

public class deceitfulmanclass {
    public int dmanstrength;
    public int basestrength = 10;
    public int strength;
    public int itemstrength = 40;
    public int hitpoints = 250;
    public String items = "zweihander";
    public String message;
    

    public void dmanencounter(){
        dmanstrength = basestrength + itemstrength;
        message = "The Deceitful Man attacks you with a " + items + "! The man has armour on! \nStrength: " + dmanstrength + "\nHP: " + hitpoints ;

        JOptionPane.showMessageDialog(null, message);
    }

}
