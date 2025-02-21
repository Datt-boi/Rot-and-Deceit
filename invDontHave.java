import javax.swing.JOptionPane;

public class invDontHave {
    public static void tron() throws Exception {

        Object[] cont = { "Continue", "Back to inventory" };

        int invreturn = JOptionPane.showOptionDialog(null,
        "You don't have that item! Keep playing to get it",
        "rot and deceit",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
        if(invreturn == 1){
            inventory.tron();
        }
        else{
            return;
        }
    }
}
