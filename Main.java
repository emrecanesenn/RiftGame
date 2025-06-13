import characters.Character;
import game.GameManager; // GameManager sınıfını import et
import maps.Home;

public class Main {
    public static void main(String[] args) {
        System.out.print("Kahraman! Lütfen adınızı giriniz: ");
        String playerName = GameManager.input.nextLine();

        Character player = GameManager.setPlayerCharacter(playerName);
        GameManager.printCharacterStats(player);
        GameManager.input.nextLine();

        // Oyunun ana menüsüne yönlendirme
        Home.teleport(player); // Ana oyun döngüsünü başlat

    }
}