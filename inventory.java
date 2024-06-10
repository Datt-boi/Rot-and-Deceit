import javax.swing.JOptionPane;

public class inventory {
    // these variables need to be outside the loop or else nothing works. silly
    // billies.
    public static String swrd = null;
    public static String rFalc = "Don't have";
    public static String lArmour = "Don't have";
    public static String spear = "Don't have";
    public static String pBerries = "Don't have";
    public static String s5 = "dont have";


    public static void tron() throws Exception {

        Object[] items = {rFalc, lArmour, spear, pBerries};

        Object[] cont = { "continue", "Back to inventory" };

        // here is where our player choics are made.
        String message = "Select the item you want to use";
        int swrd = JOptionPane.showOptionDialog(null, message, "Rot and Deceit", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, items, items[0]);

        // because of time crunch, every item is hardcoded, and there's no checks to see
        // if you actually have said item. use that as you will.
        if (swrd == 0) {
            if (rFalc == "Rusty Falchion"){
                rustyfalchion.tron();
            }
            else {
                JOptionPane.showOptionDialog(null,
                    "You don't have that item! Keep playing to get it",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
            }
        }
        // see? hardcoded. have fun cheesing items in.
        else if (swrd == 1) {
            if(lArmour == "Leather Armour"){
                leatherarmour.tron();
            }
            else {
                JOptionPane.showOptionDialog(null,
                    "You don't have that item! Keep playing to get it",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
            }
        } 
        else if (swrd == 2) {
            if(spear == "spear"){
                castleSpear.tron();
            }
            else {
                JOptionPane.showOptionDialog(null,
                    "You don't have that item! Keep playing to get it",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
            }
        } 
        else if (swrd == 3) {
            if(pBerries == "Berries"){
                poisonousBerries.tron();
            }
            else {
                JOptionPane.showOptionDialog(null,
                    "You don't have that item! Keep playing to get it",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
            }
        }
    }
}