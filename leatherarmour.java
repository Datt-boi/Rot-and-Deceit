import javax.swing.JOptionPane;

public class leatherarmour {

    public static void tron() throws Exception {

        Object[] cont = { "Continue", "Back to inventory" };
        int invreturn = JOptionPane.showOptionDialog(null,
            "You equip the Leather armour.\n it fits snugly over your body, \n feeling almost like a second skin.",
            "rot and deceit",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        Stats.armourCount = 1;

        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        } 
    }
}
