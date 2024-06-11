
import javax.swing.JOptionPane;

public class App {

        public static void main(String[] args) throws Exception {

                // These are our actions currently. every one of them has to be an object. not
                // ideal.
                Object[] cont = { "continue", "inventory" };
                Object[] Move = { "Stay here", "Move forwards, out of the cell" };
                Object[] pDirection = { "Go left", "Go right", "inventory" };
                Object[] lose = { "GAME OVER", };
                Object[] pickup = { "ignore and go surface", "take items and leave" };
                Object[] snagornice = { "leave him alone and head for the city",
                                "take the spear and leave. Not like he's going to use it" };
                Object[] forage = { "Go foraging for berries", "continue on the path" };
                Object[] tDirection = { "Go deeper into the town", "Turn back and try to leave town", "Try to find other options", "Inventory"};
                Object[] tDirection2 = {"Climb to higher ground", "Run away from the... thing", "Try to fight off the creature."};
                int time = 1;

                // while loop is here so that if player dies, the game ends.
                while (Stats.playerHP > 0) {
                        // Start of the game. continue buttons aren't used because they're just there
                        // for display purposes.
                        JOptionPane.showOptionDialog(null,
                                        "You awaken in the pitch darkness of your cell,\n a familiar smell of dried blood and rotting corpses stains your nose.\n How long has it been? Weeks? Years?\n You have no understanding of time anymore.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);

                        JOptionPane.showOptionDialog(null,
                                        "Moving around your cell, you reach for the familiar\n bars that keep you in. Feeding time is soon;\n you’ve wanted a meal for what feels like days. ",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
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
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pDirection,
                                        pDirection[0]);

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
                                                        cont,
                                                        cont[0]);
                                        // these are inventory items, stored in the inventory class. we'll yap about
                                        // that later
                                        inventory.rFalc = "Rusty Falchion";
                                        inventory.lArmour = "Leather Armour";

                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                }
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "You leave the dungeon, \n seeing light for what feels like the first time in years. \n A wave of relief wahses over you as it blesses you skin.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);

                        if (choose == 1) {
                                // here is where inventory class is actually used.
                                inventory.tron();
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "Upon leaving the dungeon, you hear someone screaming at you in a panic. \n Looking over, it’s one of the town guards. \n His eyes exude a look of pure terror as he gazes upon you, \n clearly afraid of your presence.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
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
                                inventory.spear = "spear";
                                choose = JOptionPane.showOptionDialog(null,
                                                "You take the spear off the young mans corpse,\n and head out for the town he was talking about.\n You need to get out of this place. ",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                        } else {
                                choose = JOptionPane.showOptionDialog(null,
                                                "Deciding to respect the young mans body,\n you quietly leave without taking the spear.\n You need to get to the town and get out of here.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);
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
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);

                                Stats.playerHP = Stats.playerHP - 5;

                                inventory.pBerries = "Berries";
                                JOptionPane.showOptionDialog(null,
                                                "As you return to the path,\n you quickly realise something is off..\n The woods are much too quiet.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);
                        } else {
                                choose = JOptionPane.showOptionDialog(null,
                                                "Deciding to stay on the path,\n you take in the beautiful sounds of the woods.\n Although, something isn't right.",
                                                "rot and deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "You're suspicions soon turned out to be right, \n as a rabid wolf leaps out in front of you.\n The thing reeks of rot,\n and it looks almost like chunks of flesh are falling off of the thing.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        blightedwolfclass.wolfencounter();

                        choose = JOptionPane.showOptionDialog(null,
                                        "Upon closer inspection, \n the wolf should've died to his injuries long before he reached you.\n His organs are visible through a gaping hole in his chest,\n the only thing keeping them in being his ribcage.\n This must be what the guard was warning you about.",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                        cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                        "After the fight with that freakish beast, \n you see the woods beginning to thin.\n Eventually, you find youself on the outskirts of the town,safe at last.\n Though, something's not right... The town is dead silent. \n Not one soul around.\n you're beginning to think this nightmare might not be over...",
                                        "rot and deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                        cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                "As you start to enter a denser part of town, the smell of rotting flesh fills the air. \n You start to consider that maybe the plague has already killed everyone in the city. ",
                                "rot and deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                "You walk around for a while longer, and still not a soul is to be found. \n You begin to think the guard was wrong, and that there is nothing to find here.",
                                "rot and deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tDirection, tDirection[0]);
                        
                        //If you choose option 2 (leave town), it should skip to the final fight, once we code that.

                        if (choose == 0){
                                //put the rest of the game here, until the man at the end of the game
                        }

                        if (choose == 2){
                                choose = JOptionPane.showOptionDialog(null,
                                "You look around, trying to find more options. You see a ladder on the side of one of the taller house. \n Then, suddendly, you see the first other human in the town. \nHe comes running towards you, but as he gets closer, you realize that something's not right \n You scream, realizing that his skull is visible through half of his head! Will you:",
                                "rot and deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tDirection2, tDirection2[0]);


                                if (choose == 0) {
                                        choose = JOptionPane.showOptionDialog(null,
                                        "You make a run for the ladder and jump on it, hoping it dosent break under your weight",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                        choose = JOptionPane.showOptionDialog(null,
                                        "You get to the top of the house, and knock down the ladder ensuring the creature does not follow you. \nYou look around, and see that you are very close to the walls of the city. \n Then, to your horror, you see hundreds of these deformed men trying to break through the wall and a handful of guards on the walls desperately fighting them. \n Then, the creature under you screams as the ladder falls on him. \n Several dozen of those things break off from the horde and come running towards your house, quickly surrounding it. \n They begin to knock down the supports with various tools. \n You try to find an escape, but as the house begins to fall, you finally realize there is nothing you can do.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                                        Stats.playerHP = (Stats.playerHP - 10000000);
                                }
                                if (choose == 1){
                                        choose = JOptionPane.showOptionDialog(null,
                                        "You try to run away from the horrifying beast, but you run directly into a group of at least 20 more. They rip you to shreds. Womp womp maybe you should have run back the way you came",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                                        Stats.playerHP = (Stats.playerHP - 10000000);
                                }
                                else{
                                        blightedman.blightedmanencounter();
                                }
                        }
                        if (choose == 3) {
                                inventory.tron();
                        }

                        //insert boss fight here

                        JOptionPane.showOptionDialog(null,
                                        "congratulations! you've completed the Rot and Deceit Demo! Give yourself a pat on the back.\n Oh! and before I forget!\n Please report any bugs you encounter!\n thanks for playing!",
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