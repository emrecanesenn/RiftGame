package maps;
import characters.Character; // Character sınıfını import et
import game.GameManager;
import monsters.Monster;
import monsters.Wolf;
import monsters.Golem;
import monsters.Leech;
import monsters.Guard;

import java.util.Random;

public abstract class Maps {
    private final String mapName;
    private final int mapReward;
    private boolean rewardGiven = false;
    private final String specialItem;
    private int monsterCount = 0;

    Maps(String mapName, int mapReward, String specialItem) {
        this.mapName = mapName;
        this.mapReward = mapReward;
        this.specialItem = specialItem;
    }

    // Harita tipine göre ışınlanma metodu (polimorfik olarak çağrılacak)
    public abstract void teleport(Character player);

    // Savaş metodu
    public void monsterWar(Character player, Monster monster, int specialItemOrder) {
        GameManager.chatClear();
        // Savaş döngüsü
        for(int i = 0; i < this.getMonsterCount(); i++) {
            if(player.getHeal() > 0) {
                boolean turnChance = new Random().nextBoolean();
                monster.setHealth(monster.getMaxHealth());
                System.out.println("\n\n" + monster.getName() + " sayısı : " + (getMonsterCount() - i));
                System.out.println(monster.getName() + " canavarının gücü : " + monster.getDamage());
                System.out.println("Kalan canınız : " + player.getHeal());
                System.out.println("Devam etmek için bir tuşa basınız..");
                GameManager.input.nextLine();

                do {

                    if (turnChance) { // Oyuncunun sırası

                        System.out.println("Savaş sırası sende!!");

                        // Verilen hasar, mevcut sağlık seviyesinden düşük mü kontrolü.

                        if(player.getDamage() >= monster.getHealth()) { // Verilen hasar, sağlıktan yüksek olduğunda sağlığın -'ye düşmesini önleme koşulu

                            int newDamage = player.getDamage() - (player.getDamage() - monster.getHealth());

                            monster.setHealth(monster.getHealth() - newDamage);

                            System.out.println("+" + newDamage + " hasar verdin! " + monster.getName() + " canavarının kalan canı: " + monster.getHealth());

                        } else {

                            monster.setHealth(monster.getHealth() - player.getDamage());

                            System.out.println("+" + player.getDamage() + " hasar verdin! " + monster.getName() + " canavarının kalan canı: " + monster.getHealth());

                        }

                    } else { // Canavarın sırası

                        System.out.println("Savaş sırası " + monster.getName() + " canavarında!");

                        // Verilen hasar, mevcut sağlık seviyesinden düşük mü kontrolü.
                        if(player.getArmor().equals("Yok")) {
                            if(monster.getDamage() >= player.getHeal()) { // Verilen hasar, sağlıktan yüksek olduğunda sağlığın -'ye düşmesini önleme koşulu

                                int newDamage = monster.getDamage() - (monster.getDamage() - player.getHeal());

                                player.setHeal(player.getHeal() - newDamage);

                                System.out.println("+" + newDamage + " hasar aldın! Kalan canın: " + player.getHeal());

                            } else {

                                player.setHeal(player.getHeal() - monster.getDamage());

                                System.out.println("+" + monster.getDamage() + " hasar aldın! Kalan canın: " + player.getHeal());

                            }
                        } else {
                            if(monster.getDamage() >= player.getArmorDurabilty()) { // Bu seneryo eğer alınan hasar, zırhın dayanıklılığından fazla ise çalışır.

                                int newDamage = monster.getDamage() - (monster.getDamage() - player.getArmorDurabilty());

                                player.setArmorDurabilty(player.getArmorDurabilty() - newDamage);

                                System.out.println("Savaş esnasında +" + newDamage + " hasar alarak, " + player.getArmor() + " korumanızın dayanıklılığı bitti. Bundan sonra alacağınız hasarlar sağlığınızdan düşecektir.");

                                player.setArmor("Yok");

                                if((monster.getDamage() - newDamage) >= player.getHeal()) { // Zırh kırıldıktan sonra kalan hasar, oyuncunun sağlığına eşit veya büyük ise

                                    int damage = monster.getDamage() - newDamage;

                                    int lastDamage = damage - (damage - player.getHeal());

                                    player.setHeal(player.getHeal() - lastDamage);

                                    System.out.println("+" + lastDamage + " hasar aldın! Kalan canın: " + player.getHeal());

                                }
                                else {

                                    int damage = monster.getDamage() - newDamage;

                                    player.setHeal(player.getHeal() - damage);

                                    System.out.println("+" + damage + " hasar aldın! Kalan canın: " + player.getHeal());

                                }

                            } else {

                                player.setArmorDurabilty(player.getArmorDurabilty() - monster.getDamage());

                                System.out.println("Alınan hasar " + player.getArmor() + " korumanız sayesinde sağlığınız etkilenmedi. Kalan koruma dayanıklılığı : " + player.getArmorDurabilty());

                            }
                        }

                    }
                    System.out.println("\n");
                    turnChance = !turnChance; // Savaş sırası değişimi
                    if(monster.getHealth() == 0) System.out.println("\n ---> " + monster.getName() + " canavarına karşı galip geldin! \n"); // Bir canavara karşı galibiyet alındığında

                } while(monster.getHealth() > 0 && player.getHeal() > 0); // Ya oyuncu ya da canavar ölene kadar devam edecek bir döngü

            } else { // Eğer savaşta ölürsek gerçekleşecek seneryo

                System.out.println("\nSavaştan sağ çıkamadınız :(");
                System.out.println("\n'RIFT- Escape' oyununu oynadığınız için teşekkürler.");
                System.out.println("\nAuthor: SCHEDARP");
                System.out.println("\nOyundan çıkılıyor. Hoşça kalın!");
                GameManager.input.close();
                System.exit(0); // Programı sonlandır

            }
        }

        if(player.getHeal() == 0) {
            System.out.println("\nSavaştan sağ çıkamadınız :(");
            System.out.println("\n'RIFT- Escape' oyununu oynadığınız için teşekkürler.");
            System.out.println("\nAuthor: SCHEDARP");
            System.out.println("\nOyundan çıkılıyor. Hoşça kalın!");
            GameManager.input.close();
            System.exit(0); // Programı sonlandır
        }


        System.out.println("\n\n------- Savaş Sonu Kaynaklar -------");
        if(GameManager.getSpecialItem(specialItemOrder).equals(this.getSpecialItem())) {
            int getRewardCoin = (int) (this.getMapReward() - (this.getMapReward() * 0.10));
            player.setMoney(player.getMoney() + getRewardCoin);
            System.out.println(this.mapName + " bölgesinin ödüllerini daha önce aldığınız için kazandığınız : " + getRewardCoin + " Para");
            System.out.println("\nDevam etmek için bir tuşa basın...");
            GameManager.input.nextLine();
        }
        else {
            player.setMoney(player.getMoney() + this.getMapReward());
            GameManager.setSpecialItem(specialItemOrder, this.getSpecialItem());
            System.out.println("Map Ödülleri: " + this.getMapReward() + " Para ve " + this.getSpecialItem() + " Özel Eşyası.");
            System.out.println("\nDevam etmek için bir tuşa basın...");
            GameManager.input.nextLine();
        }
        Home.teleport(player);
    }
    
    // Getter Metotlar
    public String getMapName() { return mapName; }

    public int getMapReward() { return mapReward; }

    public boolean isRewardGiven() { return rewardGiven; }

    public String getSpecialItem() { return specialItem; }

    public int getMonsterCount() { return monsterCount; }
    
    // Setter Metotlar
    public void setRewardGiven(boolean rewardGiven) { this.rewardGiven = rewardGiven; }

    public void setMonsterCount(int monsterCount) { this.monsterCount = monsterCount; }
}