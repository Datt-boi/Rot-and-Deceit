import javax.swing.JOptionPane;

public class broadSwrd {
    public static void tron() throws Exception {

        Object[] cont = { "Continue", "Back to inventory" };

        int invreturn = JOptionPane.showOptionDialog(null,
            " You equip the Broadsword. Its weight feels good in your hands, and you feel like it is an extension of your arm.",
            "rot and deceit",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        Stats.playerStr = Stats.baseStr + 50; 
        
        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        }
    }
}
