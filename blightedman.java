public class blightedman {

    public static void blightedmanencounter() {
        //Declating the variables to match the stats of the Guard.
        enemy.enemyHP = 100;
        enemy.enemyStr = 30;
        enemy.enemyType = "man";
        enemy.loseMsg = "man's relentless, almost beastlike approach to fighting";
        enemy.items = "his fists";
        enemy.drops = "nothing";

        //Starting the encounter
        enemy.encounterDisplay();
    }
}
