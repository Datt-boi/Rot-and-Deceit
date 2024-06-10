import javax.swing.JOptionPane;

public class poisonousBerries {
    public static void tron() throws Exception {

        Object[] cont = { "continue", "Back to inventory" };

        int invreturn = JOptionPane.showOptionDialog(null,
        " You eat the berries, they taste delightfully...\n BY THE NINES! I SHOULD NOT HAVE EATEN THOSE \n I'M TWEAKING!!! I THINK I'M GOING TO DIE!",
        "rot and deceit",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        Stats.playerHP = Stats.playerHP - 1482957208;
        
        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        }
    }
}
