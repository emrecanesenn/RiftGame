package maps;
import characters.Character;
import game.GameManager;

public class Home {
    public static void teleport(Character player) {
        System.out.println("\n\n");
        player.setLocation("Ev");
        player.setHeal(player.getMaxHealth());
        System.out.println(GameManager.getName() + " : Sağlığınız Yenilendi!");
        GameManager.menuTeleporting();
    }
}
