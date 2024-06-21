public class mugger {

    public static void muggerencounter() {
        //Declating the variables to match the stats of the Guard.
        enemy.enemyHP = 100;
        enemy.enemyStr = 20;
        enemy.enemyType = "mugger";
        enemy.loseMsg = "Mugger's experience in robbing innocent people";
        enemy.items = "his fists";

        //Starting the encounter
        enemy.encounterDisplay();
    }
}