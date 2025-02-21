import javax.swing.JOptionPane;

public class rustyfalchion {

    public static void tron() throws Exception {

        Object[] cont = { "Continue", "Back to inventory" };

        int invreturn = JOptionPane.showOptionDialog(null,
            "You equip the falchion.\n An elegant blade, despite the specks of rust that\n coat it.",
            "rot and deceit",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        Stats.playerStr = Stats.baseStr + 10;
        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        }
    }
}
