public class Guardclass {

    public static void guardencounter() {
        //Declating the variables to match the stats of the Guard.
        enemy.enemyHP = 30;
        enemy.enemyStr = 10;
        enemy.enemyType = "guard";
        enemy.loseMsg = "guard's mastery of the spear";
        enemy.items = "a spear";

        //Starting the encounter
        enemy.encounterDisplay();
    }
}