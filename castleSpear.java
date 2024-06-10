import javax.swing.JOptionPane;

public class castleSpear {
    public static void tron() throws Exception {

        Object[] cont = { "continue", "Back to inventory" };

        int invreturn = JOptionPane.showOptionDialog(null,
            " You equip the castle gaurds' spear.\n it is mass produced trash, \n but it'll suffice.",
            "rot and deceit",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        Stats.playerStr = Stats.baseStr + 5; 
        
        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        }
    }
}
