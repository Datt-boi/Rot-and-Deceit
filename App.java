
import javax.swing.JOptionPane;

public class App {
        public static int PHP = 100;
        public static int Bstr = 10;
        public static int maxstr = 10;
        public static int maxPHP = 100;
        public static int curPHP = 100;

        public static void main(String[] args) throws Exception {

                // These are our actions currently. every one of them has to be an object. not
                // ideal.
                Object[] Cont = { "continue", "inventory" };
                Object[] Move = { "Stay here", "Move forwards, out of the cell" };
                Object[] direction = { "Go left", "Go right", "inventory" };
                Object[] lose = { "GAME OVER", };
                Object[] pickup = { "ignore and go surface", "take items and leave" };
                Object[] snagornice = { "leave him alone and head for the city",
                                "take the spear and leave. Not like he's going to use it" };
                Object[] forage = { "Go foraging for berries", "continue on the path" };
                int time = 1;

                // while loop is here so that if player dies, the game ends.
                while (curPHP > 0) {
                        // Start of the came. continue buttons aren't used because they're just there
                        // for display purposes.
                        JOptionPane.showOptionDialog(null,
                                        "You awaken in the pitch darkness of your cell,\n a familiar smell of dried blood and rotting corpses stains your nose.\n How long has it been? Weeks? Years?\n You have no understanding of time anymore.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);

                        JOptionPane.showOptionDialog(null,
                                        "Moving around your cell, you reach for the familiar\n bars that keep you in. Feeding time is soon;\n you’ve wanted a meal for what feels like days. ",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);
                        // here is where the game actually starts. choices are stored as a variable,
                        // then compared in a if statement to find out what the player chose. Simple
                        // enough.
                        int choose = JOptionPane.showOptionDialog(null,
                                        "Curiously, however, you find nothing to grab onto.\n The door to your cell hangs ajar,\n freedom being mere steps away. ",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Move, Move[0]);
                        // this while loop is here so if the player picks one option too many times, it
                        // results in a game over.
                        while (choose < 1) {

                                choose = JOptionPane.showOptionDialog(null,
                                                "You hesitantly back away from the door. \nThis has to be a test, right?\n They must be ready to punish you if you leave.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Move,
                                                Move[0]);
                                time = time + 1;
                                if (time > 4) {
                                        choose = JOptionPane.showOptionDialog(null,
                                                        "You shut the cell door. \n you belong here, and fear of punishment ensures you stay. \n You curl up into a ball on the floor,\n and wait for tommorow.",
                                                        "rot and deceit",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                                        lose,
                                                        lose[0]);
                                        // here is said game over.
                                        System.exit(0);
                                }

                        }
                        // once that loop is over, we're back to more choices and jargen.
                        choose = JOptionPane.showOptionDialog(null,
                                        "You cautiously walk through the door. \n To the left is a near blindingly bright light,\n clearly leading to an exit of some kind. \n The right leads you down a much darker route,\n one that is completley unkown.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, direction,
                                        direction[0]);

                        if (choose == 1) {
                                choose = JOptionPane.showOptionDialog(null,
                                                "You find a rusty sword and armour on the floor. \nDo you take it?",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pickup,
                                                pickup[0]);
                                if (choose > 0) {
                                        JOptionPane.showOptionDialog(null,
                                                        "You grab the falcion as well as the Armour.\n  it'll probably be of use.",
                                                        "rot and deceit",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                                        Cont,
                                                        Cont[0]);
                                        // these are inventory items, stored in the inventory class. we'll yap about
                                        // that later
                                        String s1 = "rusty falcion";
                                        String s2 = "leather armour";
                                        inventory.cheese.add(s1);
                                        inventory.cheese.add(s2);
                                        choose = JOptionPane.showOptionDialog(null,
                                                        // quick tutorial on java inventory
                                                        "Welcome to the inventory tutorial. \n When using the inventory,\n you will see a list of your items along with a text dialouge.\n Type 'use', as well as the item name\n to ethier equip, use, or consume said item.",
                                                        "rot and deceit",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                                        Cont,
                                                        Cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                }
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "You leave the dungeon, \n seeing light for what feels like the first time in years. \n A wave of relief wahses over you as it blesses you skin.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);

                        if (choose == 1) {
                                // here is where inventory class is actually used.
                                inventory.tron();
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "Upon leaving the dungeon, you hear someone screaming at you in a panic. \n Looking over, it’s one of the town guards. \n His eyes exude a look of pure terror as he gazes upon you, \n clearly afraid of your presence.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont, Cont[0]);
                        if (choose == 1) {
                                // These if statments will be under every pop-up in case the user wants to
                                // access their inventory. Joyus, isn't it?
                                inventory.tron();
                        }
                        // fight with da guard.
                        Guardclass.guardencounter();

                        choose = JOptionPane.showOptionDialog(null,
                                        "The guard falls to the ground, blood oozing out of his mouth \n 'I-I'm sorry... I th-thought you were one... one of those THINGS!'' \n He cough up some more blood. you can tell he's going to die soon. \n 'G-get the h-hell out of h-here. Th-they are going to overun this place... g-get to the c-c..i...t....y...'\n With that final warning, the guard is gone.\n\n His spear lies beside him, free for the taking.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, snagornice,
                                        snagornice[0]);
                        if (choose == 1) {

                                if (inventory.cheese == null || inventory.cheese.isEmpty()
                                                || inventory.cheese.get(0) == null) {
                                        JOptionPane.showOptionDialog(null,
                                                        // quick tutorial on java inventory
                                                        "Welcome to the inventory tutorial. \n When using the inventory,\n you will see a list of your items along with a text dialouge.\n Type 'use', as well as the item name\n to ethier equip, use, or consume said item.",
                                                        "rot and deceit",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                                        Cont,
                                                        Cont[0]);

                                }

                                String s3 = "spear";
                                inventory.cheese.add(s3);
                                choose = JOptionPane.showOptionDialog(null,
                                                "You take the spear off the young mans corpse,\n and head out for the town he was talking about.\n You need to get out of this place. ",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                                Cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                        } else {
                                String s3 = "spear";
                                inventory.cheese.add(s3);
                                choose = JOptionPane.showOptionDialog(null,
                                                "Deciding to respect the young mans body,\n you quietly leave without taking the spear.\n You need to get to the town and get out of here.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                                Cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "As you walk down the path towrds the town,\n you watch as the brush starts to slowly cake the path. \n Eventually, the wood becomes so thick you can barely see in front of you\n With this moment of quiet, you wonder if you should maybe grab some food. \n After all, you haven't eaten in a long while.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, forage, forage[0]);
                        if (choose == 0) {
                                JOptionPane.showOptionDialog(null,
                                                "You decide it would be best to find some food,\n so you spend an hour or two off the path, searching for some grub. \n Unfortunatley, all you end up getting are some lousy berries,\n an a gash on your shoulder, thanks to a stick. \n \n You lose 5 health, but you gain berries.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                                Cont[0]);
                                curPHP = curPHP - 5;
                                if (inventory.cheese == null || inventory.cheese.isEmpty()
                                                || inventory.cheese.get(0) == null) {
                                        JOptionPane.showOptionDialog(null,
                                                        // quick tutorial on java inventory
                                                        "Welcome to the inventory tutorial. \n When using the inventory,\n you will see a list of your items along with a text dialouge.\n Type 'use', as well as the item name\n to ethier equip, use, or consume said item.",
                                                        "rot and deceit",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                                        Cont,
                                                        Cont[0]);
                                }
                                String s4 = "berries";
                                inventory.cheese.add(s4);
                                JOptionPane.showOptionDialog(null,
                                                "As you return to the path,\n you quickly realise something is off..\n The woods are much too quiet.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                                Cont[0]);

                        } else {
                                choose = JOptionPane.showOptionDialog(null,
                                                "Deciding to stay on the path,\n you take in the beautiful sounds of the woods.\n Although, something isn't right.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                                Cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "You're suspicions soon turned out to be right, \n as a rabid wolf leaps out in front of you.\n The thing reeks of rot,\n and it looks almost like chunks of flesh are falling off of the thing.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                        Cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        blightedwolfclass.wolfencounter();

                        choose = JOptionPane.showOptionDialog(null,
                                        "Upon closer inspection, \n the wolf should've died to his injuries long before he reached you.\n His organs are visible through a gaping hole in his chest,\n the only thing keeping them in being his ribcage.\n This must be what the guard was warning you about.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                        Cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                        "After the fight with that freakish beast, \n you see the woods beginning to thin.\n Eventually, you find youself on the outskirts of the town,safe at last.\n Though, something's not right... The town is dead silent. \n Not one soul around.\n you're beginning to think this nightmare might not be over...",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Cont,
                                        Cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        JOptionPane.showOptionDialog(null,
                                        "congratulations! you've completed the Rot and Deceit Demo! Give yourself a pat on the back.\n Oh! and before I forget!\n IGNORE THE SPELLING ERRORS. THIS WAS FINISHED ON CRUNCH.\n NO TIME TO CHECK WORDING.\n\n\n Please report any bugs you encounter!\n thanks for playing!",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose,
                                        lose[0]);
                        return;

                }
                JOptionPane.showOptionDialog(null,
                                "You suddenly begin to feel your body growing weak. \n The light in your eyes begins to leave, and you collapse to the ground, \n your life cut short.",
                                "rot and deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
        }

}