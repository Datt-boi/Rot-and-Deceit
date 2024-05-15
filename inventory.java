import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class inventory {
    //these variables need to be outside the loop or else nothing works. silly billies.
    public static String swrd = null;
    public static ArrayList<String> cheese = new ArrayList<String>();

    public static void tron() throws Exception {

        //here is where our player choics are made.
        swrd = JOptionPane.showInputDialog(
                Arrays.toString(cheese.toArray()) + "\n write use 'ITEM NAME' in dialouge box to use item");
        //because of time crunch, every item is hardcoded, and there's no checks to see if you actually have said item. use that as you will.
        if (swrd == "use rusty falcion") {
            JOptionPane.showInputDialog(Arrays.toString(cheese.toArray())
                    + " You equip the falchion.\n An elegant blade, despite the specks of rust that coat it.");
            App.maxstr = App.Bstr + 10;

        }
        //see? hardcoded. have fun cheesing items in.
        if (swrd == "use leather armour") {
            JOptionPane.showInputDialog(Arrays.toString(cheese.toArray())
                    + " You equip the Leather armour.\n it fits snugly over your body, \n feeling almost like a second skin.");
            App.maxPHP = App.PHP + 10;
            if (App.curPHP >= 100); {
                App.curPHP = App.maxPHP;
            }
        }
    }
}