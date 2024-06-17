import javax.swing.JOptionPane;

public class bandage {
    public static void tron() throws Exception {

        Object[] cont = { "continue", "Back to inventory" };
        int invreturn = JOptionPane.showOptionDialog(null,
            "You use the bandages. Your wounds already feel better...",
            "rot and deceit",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        Stats.playerHP = (Stats.playerHP + 25);
        inventory.bandages = "Don't have";

        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        } 
    }
}
