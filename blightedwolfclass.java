public class blightedwolfclass {

    public static void wolfencounter() {
        //Declating the variables to match the stats of the Guard.
        enemy.enemyHP = 20;
        enemy.enemyStr = 20;
        enemy.enemyType = "wolf";
        enemy.loseMsg = "wolf's relentless onslaught of teeth and claws";
        enemy.items = "its claws";
        enemy.drops = "nothing";

        //Starting the encounter
        enemy.encounterDisplay();
    }
}