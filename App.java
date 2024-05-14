
import javax.swing.JOptionPane;

public class App {
    public static int PHP = 100;
    public static int Bstr = 10;

    public static void main(String[] args) throws Exception {

        
        // These are our actions currently. every one of them has to be an object. not ideal.
        Object[] Cont = { "continue", "inventory" };
        Object[] Move = { "Stay here", "Move forwards, out of the cell" };
        Object[] direction = { "Go left", "Go right", "inventory" };
        Object[] lose = { "GAME OVER", };
        Object[] pickup = { "ignore and go surface", "take items and leave" };
        int time = 1;

        // Start of the came. continue buttons aren't used because they're just there for display purposes.

        JOptionPane.showOptionDialog(null,
                "You awaken in the pitch darkness of your cell,\n a familiar smell of dried blood and rotting corpses stains your nose.\n How long has it been? Weeks? Years?\n You have no understanding of time anymore.",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);

        JOptionPane.showOptionDialog(null,
                "Moving around your cell, you reach for the familiar\n bars that keep you in. Feeding time is soon;\n you’ve wanted a meal for what feels like days. ",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);
//here is where the game actually starts. choices are stored as a variable, then compared in a if statement to find out what the player chose. Simple enough.
        int choose = JOptionPane.showOptionDialog(null,
                "Curiously, however, you find nothing to grab onto.\n The door to your cell hangs ajar,\n freedom being mere steps away. ",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Move, Move[0]);
//this while loop is here so if the player picks one option too many times, it results in a game over.
        while (choose < 1) {

            choose = JOptionPane.showOptionDialog(null,
                    "You hesitantly back away from the door. \nThis has to be a test, right?\n They must be ready to punish you if you leave.",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Move, Move[0]);
            time = time + 1;
            if (time > 4) {
                choose = JOptionPane.showOptionDialog(null,
                        "You shut the cell door. \n you belong here, and fear of punishment ensures you stay. \n You curl up into a ball on the floor,\n and wait for tommorow.",
                        "rot and deceit",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                //here is said game over.
                System.exit(0);
            }

        }
        //once that loop is over, we're back to more choices and jargen.
        choose = JOptionPane.showOptionDialog(null, "You cautiously walk through the door. \n left or right?\n ",
                "rot and deceit",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, direction, direction[0]);

        if (choose > 0) {
            choose = JOptionPane.showOptionDialog(null,
                    "You find a rusty sword and armour on the floor. \nDo you take it?", "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pickup, pickup[0]);
            if (choose > 0) {
                JOptionPane.showOptionDialog(null,
                        "You grab the falcion as well as the Armour.\n  it'll probably be of use.", "rot and deceit",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);
                //these are invenotry items, stored in the inventory class. we'll yap about that later
                String s1 = "rusty falcion";
                String s2 = "leather Armour";
                inventory.cheese.add(s1);
                inventory.cheese.add(s2);
                JOptionPane.showOptionDialog(null,
                        //quick tutorial on java inventory
                        "Welcome to the inventory tutorial. \n When using the inventory,\n you will see a list of your items along with a text dialouge.\n Type 'use', as well as the item name\n to ethier equip, use, or consume said item.",
                        "rot and deceit",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);

            }
            choose = JOptionPane.showOptionDialog(null,
                    "You leave the dungeon, \n seeing ight for what feels like the first time in years. \n A wave of relief wahses over you as it blesses you skin.",
                    "rot and deceit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);

            if (choose > 0) {
                //here is where inventory class is actually used.
                inventory.tron();
            }

        }

    }
}
