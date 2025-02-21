
import javax.swing.JOptionPane;
/*
Notes:
All JOptionPane instances are indented for editing convenience, and are not necessary.
 */
public class App {

        public static void main(String[] args) throws Exception {

                // These are our actions currently. every one of them has to be an object. not
                // ideal.
                String message = null;
                Object[] bCont = {"Continue"};
                Object[] cont = { "Continue", "Inventory" };
                Object[] Move = { "Stay here", "Move forwards, out of the cell" };
                Object[] pDirection = { "Go left", "Go right"};
                Object[] lose = { "GAME OVER", };
                Object[] pickup = { "Ignore and go surface", "Take items and leave" };
                Object[] snagornice = { "Leave him alone and head for the city", "Take the spear and leave. Not like he's going to use it" };
                Object[] forage = { "Go foraging for berries", "Continue on the path" };
                Object[] tDirection = { "Go deeper into the town", "Turn back and try to leave town", "Try to find other options", "Inventory"};
                Object[] tDirection2 = {"Climb to higher ground", "Run away from the... thing", "Try to fight off the creature."};
                Object[] cityWalls = {"Force your way through the mob", "Try to get the city guards attention", "Try to find a way around the mob"};
                Object[] weaponsmith ={"Buy the broadsword", "Save your money for later"};
                Object[] win = {"Victory!"};
                int time = 1;

                // while loop is here so that if player dies, the game ends.
                while (Stats.playerHP > 0) {
                        // Start of the game. continue buttons aren't used because they're just there
                        // for display purposes.
                        JOptionPane.showOptionDialog(null,
                                "You awaken in the pitch darkness of your cell,\n a familiar smell of dried blood and rotting corpses stains your nose.\n How long has it been? Weeks? Years?\n You have no understanding of time anymore.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,bCont, bCont[0]);

                        JOptionPane.showOptionDialog(null,
                                "Moving around your cell, you reach for the familiar\n bars that keep you in. Feeding time is soon;\n you’ve wanted a meal for what feels like days. ",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, bCont, bCont[0]);
                        // here is where the game actually starts. choices are stored as a variable,
                        // then compared in a if statement to find out what the player chose. Simple
                        // enough.
                        int choose = JOptionPane.showOptionDialog(null,
                                "Curiously, however, you find nothing to grab onto.\n The door to your cell hangs ajar,\n freedom being mere steps away. ",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Move, Move[0]);
                        // this while loop is here so if the player picks one option too many times, it
                        // results in a game over.
                        while (choose < 1) {

                                choose = JOptionPane.showOptionDialog(null,
                                        "You hesitantly back away from the door. \nThis has to be a test, right?\n They must be ready to punish you if you leave.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Move, Move[0]);
                                time = time + 1;
                                if (time > 4) {
                                        choose = JOptionPane.showOptionDialog(null,
                                                "You shut the cell door. \n you belong here, and fear of punishment ensures you stay. \n You curl up into a ball on the floor,\n and wait for tommorow.",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                                        // here is said game over.
                                        System.exit(0);
                                }

                        }
                        // once that loop is over, we're back to more choices and jargen.
                        choose = JOptionPane.showOptionDialog(null,
                                "You cautiously walk through the door. \n To the left is a near blindingly bright light,\n clearly leading to an exit of some kind. \n The right leads you down a much darker route,\n one that is completely unkown.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pDirection, pDirection[0]);

                        if (choose == 1) {
                                choose = JOptionPane.showOptionDialog(null,
                                        "You find a rusty sword and armour on the floor. \nDo you take it?",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pickup, pickup[0]);
                                if (choose > 0) {
                                        JOptionPane.showOptionDialog(null,
                                                "You grab the falcion as well as the Armour.\n  it'll probably be of use.",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        // these are inventory items, stored in the inventory class. we'll yap about
                                        // that later
                                        message = "You gained a Rusty Falchion!";
                                        JOptionPane.showMessageDialog(null, message);
                                        inventory.rFalc = "Rusty Falchion";
                                        message = "You gained Leather Armour!";
                                        JOptionPane.showMessageDialog(null, message);
                                        inventory.lArmour = "Leather Armour";
                                }
                        }

                        message = "The inventory is now availible! \n Hit the inventory button any time it is displayed to open it.";
                        JOptionPane.showMessageDialog(null, message);

                        choose = JOptionPane.showOptionDialog(null,
                                        "You leave the dungeon, \n seeing light for what feels like the first time in years. \n A wave of relief wahses over you as it blesses you skin.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);

                        if (choose == 1) {
                                // here is where inventory class is actually used.
                                inventory.tron();
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                        "Upon leaving the dungeon, you hear someone screaming at you in a panic. \n Looking over, it’s one of the town guards. \n His eyes exude a look of pure terror as he gazes upon you, \n clearly afraid of your presence.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                // These if statments will be under every pop-up in case the user wants to
                                // access their inventory. Joyus, isn't it?
                                inventory.tron();
                        }

                        //combat tutorial
                        message = "Combat tutorial: \n \nYou are entering combat for the first time! Here are the basics: \nYou can either attack or guard. \nAttacking does what you'd expect, you attempt to attack the enemy, and if sucessful, the enemy will take damage equal to your strength. \n Guarding is a bit more complex. If you guard and are sucessful, all damage for that turn is negated, and your accuracy for next turn ONLY is boosted. \nYou can guard an unlimited amount of times, but you can't do damage when you guard. \n \n Both the enemy and the player can also miss their attacks or guards, anulling anything that you tried to do on your turn";
                        JOptionPane.showMessageDialog(null, message);

                        // fight with da guard.
                        Guardclass.guardencounter();

                        choose = JOptionPane.showOptionDialog(null,
                                        "The guard falls to the ground, blood oozing out of his mouth \n 'I-I'm sorry... I th-thought you were one... one of those THINGS!'' \n He cough up some more blood. you can tell he's going to die soon. \n 'G-get the h-hell out of h-here. Th-they are going to overun this place... g-get to the c-c..i...t....y...'\n With that final warning, the guard is gone.\n\n His spear lies beside him, free for the taking.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, snagornice,
                                        snagornice[0]);
                        if (choose == 1) {
                                inventory.spear = "spear";
                                choose = JOptionPane.showOptionDialog(null,
                                                "You take the spear off the young mans corpse,\n and head out for the town he was talking about.\n You need to get out of this place. ",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                        } else {
                                choose = JOptionPane.showOptionDialog(null,
                                                "Deciding to respect the young mans body,\n you quietly leave without taking the spear.\n You need to get to the town and get out of here.",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont,
                                                cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }
                        }
                        //Choose whether or not to look for berries
                        choose = JOptionPane.showOptionDialog(null,
                                        "As you walk down the path towrds the town,\n you watch as the brush starts to slowly cake the path. \n Eventually, the wood becomes so thick you can barely see in front of you\n With this moment of quiet, you wonder if you should maybe grab some food. \n After all, you haven't eaten in a long while.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, forage, forage[0]);
                        //If you choose to look for berries.
                        if (choose == 0) {
                                JOptionPane.showOptionDialog(null,
                                        "You decide it would be best to find some food,\n so you spend an hour or two off the path, searching for some grub. \n Unfortunatley, all you end up getting are some lousy berries,\n an a gash on your shoulder, thanks to a stick. \n \n You lose 5 health, but you gain berries.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                Stats.playerHP = Stats.playerHP - 5;
                                inventory.pBerries = "Berries";

                                choose = JOptionPane.showOptionDialog(null,
                                        "As you return to the path,\n you quickly realise something is off..\n The woods are much too quiet.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }
                        } 
                        //If you choose not to look for berries
                        else {
                                choose = JOptionPane.showOptionDialog(null,
                                        "Deciding to stay on the path,\n you take in the beautiful sounds of the woods.\n Although, something isn't right.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }
                        }
                        choose = JOptionPane.showOptionDialog(null,
                                "You're suspicions soon turned out to be right, \n as a rabid wolf leaps out in front of you.\n The thing reeks of rot,\n and it looks almost like chunks of flesh are falling off of the thing.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        //wolf fight
                        blightedwolfclass.wolfencounter();

                        choose = JOptionPane.showOptionDialog(null,
                                "Upon closer inspection, \n the wolf should've died to his injuries long before he reached you.\n His organs are visible through a gaping hole in his chest,\n the only thing keeping them in being his ribcage.\n This must be what the guard was warning you about.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                "After the fight with that freakish beast, \n you see the woods beginning to thin.\n Eventually, you find youself on the outskirts of the town,safe at last.\n Though, something's not right... The town is dead silent. \n Not one soul around.\n you're beginning to think this nightmare might not be over...",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                "As you start to enter a denser part of town, the smell of rotting flesh fills the air. \n You start to consider that maybe the plague has already killed everyone in the city. ",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        choose = JOptionPane.showOptionDialog(null,
                                "You walk around for a while longer, and still not a soul is to be found. \n You begin to think the guard was wrong, and that there is nothing to find here.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tDirection, tDirection[0]);
                        
                        //If you choose option 2 (leave town), it should skip to the final fight, once we code that.

                        if (choose == 0){
                                choose = JOptionPane.showOptionDialog(null,
                                "You keep walking into denser and denser parts of the town.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "Your search goes on and on, \nUntil at long last, you hear voices in the distance. \n You eagerly walk towards the voices.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "Although as you get closer, you realize \n Something is wrong. \n Very wrong.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "Those arent the noises of a city.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "Those noises are a deafening mix of battle cries and screams.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "It gets louder and louder as you get closer.\n Your ears can barely take it anymore.\n But you press on. You must find out what the guard was warning about.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "You finally see what the noise was coming from.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "The inner city walls, with guards desperately throwing anything they can find down at a horde of... \n Something. It looks human but it clearly isnt.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                "The guard told you to get into the city. That is all you can do anyway, nothing waits for you the way you came. How will you proceed?",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cityWalls, cityWalls[0]);

                                if(choose==0){
                                        choose = JOptionPane.showOptionDialog(null,
                                        "You try to force your way through, and immediatly get torn to pieces. \n \n \n ...what did you think was gonna happen ya dingus?",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                                        Stats.playerHP = (Stats.playerHP - 100000000);
                                        System.exit(0);
                                }

                                if(choose==1){
                                        choose = JOptionPane.showOptionDialog(null,
                                        "You climb onto a roof, and start trying to get a guards attention. \n A sense of relief overwhelms you as the giard notices you. \n Unfortunately, some of the mob saw you climb the roof and decided to follow you up. \n And so, he shoots a cannon at the house you stand on, killing you along with those that followed you.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                                        Stats.playerHP = (Stats.playerHP - 10000000);
                                        System.exit(0);
                                        
                                }
                                choose = JOptionPane.showOptionDialog(null,
                                        "You start to explore the perimiter of the city walls, taking good care to not let the mob of creatures notice you.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                choose = JOptionPane.showOptionDialog(null,
                                        "In doing so, you are able to get a much better look at what the creatures look like. \n They seem to be afflicted with the same blight that wolf had, and what you now assume must be what the guard was referring to. \nTHese are men, who look like they shouldnt be alive, with explosed bones and organs. \n You assume, that like the wolf, they behave extremely aggresively.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                choose = JOptionPane.showOptionDialog(null,
                                        "After a while, the mob seems to dissipate, and the city wall becomes surrounded by less and less men. \n You approach the wall, and find a hidden doorway in the wall, leading into a tunnel.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                choose = JOptionPane.showOptionDialog(null,
                                        "You emerge in a store, which has been boarded up. It looks like a clinic of sorts. It has mostly been looted, but some bandages still lay around. \n You check the cash safe. Empty.\nBut being the criminal that you are, you know to check underneath the safe, and sure enough a small amount of coins lies there for the taking.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }
                                
                                message = "you gained bandages!";
                                JOptionPane.showMessageDialog(null, message);
                                inventory.bandages = "Bandages";

                                message = "You got ¤30!!";
                                JOptionPane.showMessageDialog(null, message);
                                Stats.money = 30;
                                
                                choose = JOptionPane.showOptionDialog(null,
                                        "You emerge onto a street with dense townhouses. \n This time, it is not dead silent, however there are still much fewer people then you would expect in a place like this.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                if (choose == 1) {
                                        inventory.tron();
                                }

                                choose = JOptionPane.showOptionDialog(null,
                                        "As you walk down the street, towards the grand castle in the center, you see a weaponsmith.",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }
                                
                                        choose = JOptionPane.showOptionDialog(null,
                                        "You enter the weaponsmith, half hoping it is also closed. \nHowever, it is very much open for buisness, as there is a man standing at the counter. \n You ask the man for a nice blade, to defend against the blighted. \n He answers that due to a shortage in steel, they only were able to mass produce one kind of sword.\n Do you buy it?",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, weaponsmith, weaponsmith[0]);
                                        if (choose == 0) {
                                                if (Stats.money >= 25){
                                                        message = "You spent ¤25 and bought a Broadsword!";
                                                        inventory.brSwrd = "Broadsword";
                                                        Stats.money = (Stats.money - 25);
                                                }
                                                else{
                                                        message = "You can't afford this!";
                                                }
                                                JOptionPane.showMessageDialog(null, message);
                                        }

                                        else {
                                                choose = JOptionPane.showOptionDialog(null,
                                                        "You choose to not buy the sword, and instead save your little money for other things.",
                                                        "Rot and Deceit",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                                        if (choose == 1) {
                                                                inventory.tron();
                                                        }
                                        }

                                        choose = JOptionPane.showOptionDialog(null,
                                                "You leave the weaponsmith, and continue making your way further into the city.",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                        choose = JOptionPane.showOptionDialog(null,
                                                "Suddendly, a man with a knife graps you! \n He declares that you must forfeit all your valuables to him or he will end your life right here! \n You fight the man!",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                        mugger.muggerencounter();

                                        Stats.money = (Stats.money + 20);
                                        
                                        // INCOMPLETE AND INACTIVE continuation of the city story.
                                        // choose = JOptionPane.showOptionDialog(null,
                                        //         "Having defeated the man, you start towards the city center once again.",
                                        //         "Rot and Deceit",
                                        //         JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        // if (choose == 1) {
                                        //         inventory.tron();
                                        // }

                                        // choose = JOptionPane.showOptionDialog(null,
                                        //         "The walk is long and tiring, the city is much bigger then you thought.",
                                        //         "Rot and Deceit",
                                        //         JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        // if (choose == 1) {
                                        //         inventory.tron();
                                        // }

                                        // choose = JOptionPane.showOptionDialog(null,
                                        //         "You then realize that you havent eaten yet. As the adrenaline wears off, you realize that you have to eat, now.",
                                        //         "Rot and Deceit",
                                        //         JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        //if (choose == 1) {
                                         //       inventory.tron();
                                        //}

                                        choose = JOptionPane.showOptionDialog(null,
                                                "To your shock, you see the city walls collapsing. Blighted men are already pouring in \n You need to get out of here as fast as possible.",
                                                "Rot and Deceit",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                                        if (choose == 1) {
                                                inventory.tron();
                                        }

                                        message = "Adrenaline boosts your strength and HP!";
                                        JOptionPane.showMessageDialog(null, message);
                                        Stats.playerStr = (Stats.playerStr + 50);
                                        Stats.playerHP = (Stats.playerHP + 50);
                        }

                        
                        //If you choose to try to find other options at the city entrance. All paths here lead to death.
                        if (choose == 2){
                                choose = JOptionPane.showOptionDialog(null,
                                "You look around, trying to find more options. You see a ladder on the side of one of the taller house. \n Then, suddendly, you see the first other human in the town. \nHe comes running towards you, but as he gets closer, you realize that something's not right \n You scream, realizing that his skull is visible through half of his head! Will you:",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tDirection2, tDirection2[0]);

                                //If you climb to higher ground
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
                                        System.exit(0);
                                }

                                //If you try to run 
                                if (choose == 1){
                                        choose = JOptionPane.showOptionDialog(null,
                                        "You try to run away from the horrifying beast, but you run directly into a group of at least 20 more. They rip you to shreds. Womp womp maybe you should have run back the way you came",
                                        "Rot and Deceit",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                                        Stats.playerHP = (Stats.playerHP - 10000000);
                                        System.exit(0);
                                }
                                //If you try to fight the creature. You should not be able to win this encounter.
                                else{
                                        blightedman.blightedmanencounter();
                                }
                        }
                        if (choose == 3) {
                                inventory.tron();
                        }

                        //insert boss fight here
                        choose = JOptionPane.showOptionDialog(null,
                                "You get to the docks. You try to board a boat, but a man bars your access, demanding you pay an exorbitant sum. \n WHen you say you cant pay, he attacks you!",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, cont, cont[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }

                        deceitfulman.Manencounter();

                        choose = JOptionPane.showOptionDialog(null,
                                "After that harrowing fight, you board the boat. \n You set sail, letting the waves carry you away from this dying kingdom that once imprisoned you, truly free at last.",
                                "Rot and deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, win, win[0]);
                        if (choose == 1) {
                                inventory.tron();
                        }


                        JOptionPane.showOptionDialog(null,
                                "Congratulations! you've completed the Rot and Deceit storyline! Give yourself a pat on the back.\n Oh! and before I forget!\n Please report any bugs you encounter!\n thanks for playing! \n \n Version 1.2",
                                "Rot and deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
                        return;

                }
                JOptionPane.showOptionDialog(null,
                                "You suddenly begin to feel your body growing weak. \n The light in your eyes begins to leave, and you collapse to the ground, \n your life cut short.",
                                "Rot and Deceit",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
        }
}