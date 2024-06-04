import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class inventory {
    // these variables need to be outside the loop or else nothing works. silly
    // billies.
    public static String swrd = null;
    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<String> inv = new ArrayList<String>();
    public static String rFalc = "dont have";
    public static String lArmour = "dont have";
    public static String spear = "dont have";
    public static String pBerries = "dont have";
    public static String s5 = "dont have";


    public static void tron() throws Exception {

        if (inventory.items == null || inventory.items.isEmpty() 
                || inventory.items.get(0) == null) {
            return;
        }
        Object[] cont = { "continue", "Back to inventory" };
        Object[] selections = {rFalc, lArmour, spear, pBerries};

        // here is where our player choics are made.
        String message = "Select the item you want to use";
        int swrd = JOptionPane.showOptionDialog(null, message, "Rot and Deceit", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, selections, selections[0]);

        // because of time crunch, every item is hardcoded, and there's no checks to see
        // if you actually have said item. use that as you will.
        if (swrd == 0) {
            JOptionPane.showOptionDialog(null,
                "You equip the falchion.\n An elegant blade, despite the specks of rust that\n coat it.",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                cont[0]);
            App.playerStr = App.Bstr + 10;
        }
        // see? hardcoded. have fun cheesing items in.
        else if (swrd == 1) {
            JOptionPane.showInputDialog(Arrays.toString(items.toArray())
                + " You equip the Leather armour.\n it fits snugly over your body, \n feeling almost like a second skin.");
            App.maxPHP = App.basePlayerHP + 10;
            if (App.PlayerHP >= 100) {
                App.PlayerHP = App.maxPHP;
            }
        } 
        else if (swrd == 2) {
            JOptionPane.showOptionDialog(null,
                " You equip the castle gaurds' spear.\n it is mass produced trash, \n but it'll suffice.",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
            App.playerStr = App.Bstr + 5; 
        } 
        else if (swrd == 3) {
            JOptionPane.showOptionDialog(null,
                " You eat the berries, they taste delighfully...\n BY THE NINES! I SHOULD NOT HAVE EATEN THOSE \n I'M TWEAKING!!! I THINK I'M GOING TO DIE!",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
            App.PlayerHP = App.PlayerHP - 1482957208;
        }
    }
}