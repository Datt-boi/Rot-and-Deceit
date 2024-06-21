import javax.swing.JOptionPane;

public class poisonousBerries {
    public static void tron() throws Exception {

        Object[] lose = { "GAME OVER" };

        JOptionPane.showOptionDialog(null,
        " You eat the berries, they taste delightfully...\n BY THE NINES! I SHOULD NOT HAVE EATEN THOSE \n I'M TWEAKING!!! I THINK I'M GOING TO DIE!",
        "rot and deceit",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, lose, lose[0]);
        Stats.playerHP = Stats.playerHP - 1482957208;
        System.exit(0);
    }
}
