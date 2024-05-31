import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class inventory {
    // these variables need to be outside the loop or else nothing works. silly
    // billies.
    public static String swrd = null;
    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<String> inv = new ArrayList<String>();
    public static String s1 = null;
    public static String s2 = null;
    public static String s3 = null;
    public static String s4 = null;
    public static String s5 = null;


    public static void tron() throws Exception {

        if (inventory.items == null || inventory.items.isEmpty() 
                || inventory.items.get(0) == null) {
            return;
        }
        Object[] cont = { "continue", "Back to inventory" };

        // here is where our player choics are made.
        swrd = JOptionPane.showInputDialog(
                Arrays.toString(items.toArray()) + "\n write use 'ITEM NAME' in dialouge box to use item. no caps.");
        // because of time crunch, every item is hardcoded, and there's no checks to see
        // if you actually have said item. use that as you will.
        if (swrd.equals("use rusty falcion")) {
            if (items.contains(s1)){
                JOptionPane.showOptionDialog(null,
                    "You equip the falchion.\n An elegant blade, despite the specks of rust that\n coat it.",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);
                App.playerStr = App.Bstr + 10;
            }
            else{
                JOptionPane.showOptionDialog(null,
                    "You don't have that item!",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);
            }

        }
        // see? hardcoded. have fun cheesing items in.
        else if (swrd.equals("use leather armour")) {
            if (items.contains(s2)){
                JOptionPane.showInputDialog(Arrays.toString(items.toArray())
                    + " You equip the Leather armour.\n it fits snugly over your body, \n feeling almost like a second skin.");
                App.maxPHP = App.basePlayerHP + 10;
                if (App.PlayerHP >= 100) {
                    App.PlayerHP = App.maxPHP;
                }
            }
            else{
                JOptionPane.showOptionDialog(null,
                    "You don't have that item!",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);
            }
        } else if (swrd.equals("use spear")) {
            JOptionPane.showOptionDialog(null,
                    " You equip the castle gaurds' spear.\n it is mass produced trash, \n but it'll suffice.",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);
            App.playerStr = App.Bstr + 5;
        } else if (swrd.equals("use berries")) {
            ;
            JOptionPane.showOptionDialog(null,
                    " You eat the berries, they taste delighfully...\n BY THE NINES! I SHOULD NOT HAVE EATEN THOSE \n I'M TWEAKING!!! I THINK I'M GOING TO DIE!",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                    cont[0]);

            App.PlayerHP = App.PlayerHP - 1482957208;
        }

    }
}