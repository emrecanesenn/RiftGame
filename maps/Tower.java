package maps;
import characters.Character;
import game.GameManager; // GameManager'a erişim için

import monsters.Guard;
import monsters.Monster;

import java.util.Random;

public class Tower extends Maps{
    public Tower() {
        super("Zamanın Kulesi", 300, "Kozmik Pusula"); // mapName'i "Zamanın Kulesi" olarak güncelledim
    }

    @Override
    public void teleport(Character player) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        player.setLocation(this.getMapName()); // Oyuncunun konumunu güncelle
        this.setMonsterCount(new Random().nextInt(3) + 1); // 1-3 arası canavar
        Monster monster = new Guard();
        System.out.println("Işınlanılıyor... \nIşınlanıldı : " + this.getMapName());
        System.out.println("Bölgede " + this.getMonsterCount() + " tane " + monster.getName() + " tespit edildi."); // Canavar sayısı dinamik
        System.out.print("Savaşmak mı istersin? Kaçmak mı? (War / Run) : ");

        String choice = GameManager.input.nextLine(); // Sadece kelimeyi oku

        if(choice.equalsIgnoreCase("War")) { // Büyük/küçük harf duyarlılığını kaldır

            monsterWar(player, monster, 3);

        }
        else if(choice.equalsIgnoreCase("Run")) {
            int lucky = new Random().nextInt(10); // 0-9 arası sayı
            if(lucky < 7) { // %70 şans (0,1,2,3,4,5,6 gelirse)
                System.out.println("Başarıyla kaçtın!");
                Home.teleport(player);
            } else {
                System.out.println("Kaçamadın! Savaş başlıyor!");

                monsterWar(player, monster, 3);
            }
        } else {
            System.out.println("Geçersiz seçim. Kaçış başarısız oldu, savaş başlıyor!");

            monsterWar(player, monster, 3);
        }
    }
}