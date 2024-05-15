import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class inventory {
    // these variables need to be outside the loop or else nothing works. silly
    // billies.
    public static String swrd = null;
    public static ArrayList<String> cheese = new ArrayList<String>();

    public static void tron() throws Exception {

        if (inventory.cheese == null || inventory.cheese.isEmpty()
        || inventory.cheese.get(0) == null){
            return;
        }
        Object[] cont = { "continue", "Back to inventory" };

        // here is where our player choics are made.
        swrd = JOptionPane.showInputDialog(
                Arrays.toString(cheese.toArray()) + "\n write use 'ITEM NAME' in dialouge box to use item. no caps.");
        // because of time crunch, every item is hardcoded, and there's no checks to see
        // if you actually have said item. use that as you will.
        if (swrd.equals("use rusty falcion")) {
            JOptionPane.showOptionDialog(null,
                    "You equip the falchion.\n An elegant blade, despite the specks of rust that\n coat it.",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);
            App.maxstr = App.Bstr + 10;
        }
        // see? hardcoded. have fun cheesing items in.
        else if (swrd.equals("use leather armour")) {
            JOptionPane.showInputDialog(Arrays.toString(cheese.toArray())
                    + " You equip the Leather armour.\n it fits snugly over your body, \n feeling almost like a second skin.");
            App.maxPHP = App.PHP + 10;
            if (App.curPHP >= 100) {
                App.curPHP = App.maxPHP;
            }
        } else if (swrd.equals("use spear")) {
            JOptionPane.showOptionDialog(null,
                    " You equip the castle gaurds' spear.\n it is mass produced trash, \n but it'll suffice.",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);
            App.maxstr = App.Bstr + 5;
        } else if (swrd.equals("use berries")) {
            ;
            JOptionPane.showOptionDialog(null,
                    " You eat the berries, they taste delighfully...\n BY THE NINES! I SHOULD NOT HAVE EATEN THOSE \n I'M TWEAKING!!! I THINK I'M GOING TO DIE!",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);

            // );
            App.curPHP = App.curPHP - 1000;
        }

    }
}