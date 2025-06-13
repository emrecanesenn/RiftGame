package game;

import maps.Home;
import maps.Forest;
import maps.Cave;
import maps.Swamp;
import maps.Tower;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import characters.Archer;

import java.util.Random;
import java.util.Scanner;

public class GameManager {
    static Home home = new Home();
    static Forest forest = new Forest();
    static Cave cave = new Cave(); // Diğer map'ler de burada
    static Swamp swamp = new Swamp();
    static Tower tower = new Tower();
    static final String gameName = "RIFT";
    static Character selectedCharacter = null; // Seçilen oyuncu karakterini tutar
    static String[] specialItem = {"0", "0", "0", "0"}; // Toplanan özel eşyalar

    public static void chatClear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static String getSpecialItem(int order) {
        return specialItem[order];
    }

    public static void setSpecialItem(int order, String specialItemName) {
        specialItem[order] = specialItemName;
    }

    public static Scanner input = new Scanner(System.in); // Scanner nesnesini sadece bir kez burada oluştur

    public static Character setPlayerCharacter(String characterName) {
        System.out.println("----------------------------");
        System.out.println("1- Warrior (Savaşçı) / Sağlık : 120 - Güç : 15 - Silah : El - Başlangıç Parası : 50");
        System.out.println("2- Archer (Okçu) / Sağlık : 100 - Güç : 18 - Silah : Basit Yay - Başlangıç Parası : 60");
        System.out.println("3- Wizard (Büyücü) / Sağlık : 80 - Güç : 12 - Silah : Basit Asa - Başlangıç Parası : 80");
        System.out.print("Bir karakter seçmelisin: ");
        int select = input.nextInt();

        switch (select) {
            case 1:
                selectedCharacter = new Warrior("Warrior", "WARR", characterName);
                break;
            case 2:
                selectedCharacter = new Archer("Archer", "ARCH", characterName);
                break;
            case 3:
                selectedCharacter = new Wizard("Wizard", "WZRD", characterName);
                break;
            default:
                int rand = new Random().nextInt(3);
                if (rand == 0) {
                    selectedCharacter = new Warrior("Warrior", "WARR", characterName);
                } else if (rand == 1) {
                    selectedCharacter = new Archer("Archer", "ARCH", characterName);
                } else {
                    selectedCharacter = new Wizard("Wizard", "WZRD", characterName);
                }
                break;
        }
        input.nextLine();
        selectedCharacter.initializeStats();
        return selectedCharacter;
    }

    public static void printCharacterStats(Character player) {
        chatClear(); // Konsol temizleme (geçici)
        System.out.println("\n\n" + player.getType() + " | " + player.getName());
        System.out.println("\nİstatistikleriniz;");
        System.out.println("Para: " + player.getMoney());
        System.out.println("Sağlık: " + player.getHeal());
        System.out.println("Güç: " + player.getDamage());
        System.out.println("Silah: " + player.getWeapon());
        System.out.println("Zırh: " + player.getArmor() + "(" + player.getArmorDurabilty() + ")");
        System.out.println("\nDevam etmek için bir tuşa basın..."); // Kullanıcının çıktıyı görmesini bekle
    }

    public static void portalStatus() {
        chatClear(); // Konsol temizleme (geçici)
        boolean isPortalOpened = true; // Portal durumu
        System.out.println("\n------ Eve Dönüş ------\n");
        for (int i = 0; i < specialItem.length; i++) { // Döngü koşulu specialItem.length'e kadar olmalı
            if (specialItem[i].equals("0")) {
                System.out.println((i + 1) + " - Keşfedilmedi");
                isPortalOpened = false;
            } else {
                System.out.println((i + 1) + " - " + specialItem[i]);
            }
        }
        // Döngü bittikten sonra portal durumu
        if (isPortalOpened == false) System.out.println("\nPortal Durumu : Kapalı");
        else {
            System.out.println("\nPortal Durumu : Açık");
            System.out.print("Başardınız! Oyunu bitirip normal hayata dönmek ister misiniz ? (E/H) : ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("E")) {
                chatClear();
                System.out.println("\n'RIFT- Escape' oyununu oynadığınız için teşekkürler.");
                System.out.println("\nAuthor: SCHEDARP");
                System.out.println("\nOyundan çıkılıyor. Hoşça kalın!");
                input.close();
                System.exit(0); // Programı sonlandır
            } else if (choice.equalsIgnoreCase("H")) {
                menuTeleporting();
            }
        }

        System.out.println("\n-----------------------\n");
        System.out.println("\nDevam etmek için bir tuşa basın..."); // Kullanıcının çıktıyı görmesini bekle
    }

    public static void getMenu() {
        String[] maps = {"Ev", "Işık Ormanı", "Yankı Mağaraları", "Suskun Bataklık", "Zamanın Kulesi"};
        System.out.println("\n----- Yönlendirici -----\n");
        System.out.println("Bölgeler;");
        for (int i = 0; i < maps.length; i++) { // maps.length'e kadar döngü
            if (maps[i].equals(selectedCharacter.getLocation())) { // Bu kısım Character sınıfında location niteliği olunca aktifleşir
                System.out.println(i + " - " + maps[i] + " (Buradasınız)");
            } else {
                System.out.println(i + " - " + maps[i]);
            }
        }
        System.out.println("\nBilgiler;");
        System.out.println("5 - Kişisel Durum");
        System.out.println("6 - Özel Eşyalar ve Portal Durumu");
        System.out.println("7 - Mağaza\n");
        System.out.println("911 - Oyunu Bitir\n");
        System.out.println("------------------------");
    }

    public static void menuTeleporting() {
        Forest forest = new Forest();
        Cave cave = new Cave();
        Swamp swamp = new Swamp();
        Tower tower = new Tower();
        boolean teleportFlag = false; // Hata durumunu yönetmek için

        while (true) {
            getMenu(); // Menüyü her seferinde tekrar göster
            if (teleportFlag) { // Geçersiz giriş yapıldıysa uyarıyı göster
                System.out.println("Lütfen geçerli bir işlem giriniz!!");
                teleportFlag = false; // Uyarı gösterildikten sonra bayrağı sıfırla
            }
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
            int locationChoice = input.nextInt();
            input.nextLine();
            switch (locationChoice) {
                case 0: // Ev
                    // Şu anki konum ile aynı yerde olup olmadığını kontrol ediyoruz.
                    if (selectedCharacter.getLocation().equals("Ev")) {
                        System.out.println("Zaten Ev'desiniz.");
                    } else {
                        Home.teleport(selectedCharacter); // Ev'e ışınlan
                    }
                    break;
                case 1: // Işık Ormanı
                    if (selectedCharacter.getLocation().equals("Işık Ormanı")) {
                        System.out.println("Zaten Işık Ormanı'ndasınız.");
                    } else {
                        forest.teleport(selectedCharacter); // Ormana ışınlan
                    }
                    break;
                case 2: // Yankı Mağaraları
                    if (selectedCharacter.getLocation().equals("Yankı Mağaraları")) {
                        System.out.println("Zaten Yankı Mağaraları'ndasınız.");
                    } else {
                        cave.teleport(selectedCharacter);
                    }
                    break;
                case 3: // Suskun Bataklık
                    if (selectedCharacter.getLocation().equals("Suskun Bataklık")) {
                        System.out.println("Zaten Suskun Bataklık'tasınız.");
                    } else {
                        swamp.teleport(selectedCharacter);
                    }
                    break;
                case 4: // Zamanın Kulesi
                    if (selectedCharacter.getLocation().equals("Zamanın Kulesi")) {
                        System.out.println("Zaten Zamanın Kulesi'ndesiniz.");
                    } else {
                        tower.teleport(selectedCharacter);
                    }
                    break;
                case 5:
                    printCharacterStats(selectedCharacter);
                    break;
                case 6:
                    portalStatus();
                    break;
                case 7:
                    Store(selectedCharacter);
                    break;
                case 911: // Oyunu Bitir
                    System.out.println("\nOyundan çıkılıyor. Hoşça kalın!");
                    input.close();
                    System.exit(0); // Programı sonlandır
                default: // Geçersiz seçim
                    teleportFlag = true; // Uyarı bayrağını ayarla
                    break;
            }
            input.nextLine();
        }
    }

    public static void Store(Character player) {
        boolean shopFlag = false;
        int storeChoice = 0;
        while (true) {
            chatClear();
            System.out.println("----> Mağaza\n");
            System.out.println("1- Silahlar (Güç Artışı)");
            System.out.println("2- Zırhlar (Ekstra Sağlık)\n");
            System.out.println("3- Mağazadan çık");

            if(storeChoice == 3) { break; }

            do {
                if (shopFlag) {
                    System.out.println("Lütfen geçerli bir değer giriniz!!");
                    shopFlag = false;
                }
                System.out.print("Gitmek istediğiniz menüyü giriniz : ");
                storeChoice = input.nextInt();

                if (storeChoice == 1) {
                    chatClear();
                    System.out.println("Mağaza -> Silahlar\n");
                    System.out.println("1- Tahta " + getWeaponType(player) + " (+5 Güç) - 50$");
                    System.out.println("2- Demir " + getWeaponType(player) + " (+10 Güç) - 120$");
                    System.out.println("3- Çelik " + getWeaponType(player) + " (+15 Güç) - 220$");
                    System.out.println("4- Mithril " + getWeaponType(player) + " (+20 Güç) - 380$");
                    System.out.println("5- Kadim Silah (+25 Güç) - 550$");
                    System.out.println("6- Önceki menüye dön ->\n");
                    System.out.println("Mevcut paranız : " + player.getMoney());
                    System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
                    int itemChoice = input.nextInt();
                    input.nextLine();
                    if(itemChoice == 6) {
                        break;
                    }
                    else {
                        if (purchasingProcess(itemChoice, player, storeChoice)) {
                            System.out.println("Satın Alım Başarılı!");
                            System.out.println("Yeni Silahınız: " + player.getWeapon());
                            System.out.print("Devam etmek için bir tuşa basınız..");
                            return;
                        }
                        else {
                            System.out.println("Başarısız satın alım!!");
                            System.out.print("Devam etmek için bir tuşa basınız..");
                            return;
                        }
                    }
                } else if (storeChoice == 2) {
                    chatClear();
                    System.out.println("Mağaza -> Zırhlar\n");
                    System.out.println("1- Deri Yelek (+20 Zırh) - 75$");
                    System.out.println("2- Zincir Gömlek (+40 Zırh) - 150$");
                    System.out.println("3- Çelik Göğüslük (+60 Zırh) - 250$");
                    System.out.println("4- Mithril Zırh (+80 Zırh) - 400$");
                    System.out.println("5- Efsanevi Kalkan (+100 Zırh) - 600$");
                    System.out.println("6- Önceki menüye dön ->\n");
                    System.out.println("Mevcut paranız : " + player.getMoney());
                    System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
                    int itemChoice = input.nextInt();
                    input.nextLine();
                    if(itemChoice == 6) {
                        break;
                    } else {
                        if (purchasingProcess(itemChoice, player, storeChoice)) {
                            System.out.println("Satın Alım Başarılı!");
                            System.out.println("Yeni zırhınız: " + player.getArmor() + "(" + player.getArmorDurabilty() + ")");
                            System.out.print("Devam etmek için bir tuşa basınız..");
                            return;
                        }
                        else {
                            System.out.println("Başarısız satın alım!!");
                            System.out.print("Devam etmek için bir tuşa basınız..");
                            return;
                        }
                    }
                } else if (storeChoice == 3) {
                    break;
                } else {
                    shopFlag = true;
                    continue;
                }
            } while (true);
        }
    }

    private static boolean purchasingProcess(int itemChoice, Character player, int storeChoice) {
        if (storeChoice == 1) {
            switch (itemChoice) {
                case 1:
                    if(player.getMoney() >= 50) {
                        player.setWeapon("Tahta " + getWeaponType(player));
                        player.setDamage(player.getDefaultDamage() + 5);
                        player.setMoney(player.getMoney() - 50);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 2:
                    if(player.getMoney() >= 120) {
                        player.setWeapon("Demir " + getWeaponType(player));
                        player.setDamage(player.getDefaultDamage() + 10);
                        player.setMoney(player.getMoney() - 120);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 3:
                    if(player.getMoney() >= 220) {
                        player.setWeapon("Çelik " + getWeaponType(player));
                        player.setDamage(player.getDefaultDamage() + 15);
                        player.setMoney(player.getMoney() - 220);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 4:
                    if(player.getMoney() >= 380) {
                        player.setWeapon("Mithril " + getWeaponType(player));
                        player.setDamage(player.getDefaultDamage() + 20);
                        player.setMoney(player.getMoney() - 380);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 5:
                    if(player.getMoney() >= 550) {
                        player.setWeapon("Kadim Silah");
                        player.setDamage(player.getDefaultDamage() + 25);
                        player.setMoney(player.getMoney() - 550);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
            }
        }
        else if (storeChoice == 2) {
            switch (itemChoice) {
                case 1:
                    if(player.getMoney() >= 75) {
                        player.setArmor("Deri Yelek");
                        player.setArmorDurabilty(20);
                        player.setMoney(player.getMoney() - 75);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 2:
                    if(player.getMoney() >= 150) {
                        player.setArmor("Zincir Gömlek");
                        player.setArmorDurabilty(40);
                        player.setMoney(player.getMoney() - 150);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 3:
                    if(player.getMoney() >= 250) {
                        player.setArmor("Çelik Göğüslük");
                        player.setArmorDurabilty(60);
                        player.setMoney(player.getMoney() - 250);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 4:
                    if(player.getMoney() >= 400) {
                        player.setArmor("Mithril Zırh");
                        player.setArmorDurabilty(80);
                        player.setMoney(player.getMoney() - 400);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
                case 5:
                    if(player.getMoney() >= 600) {
                        player.setArmor("Efsanevi Kalkan");
                        player.setArmorDurabilty(100);
                        player.setMoney(player.getMoney() - 600);
                        return true;
                    } else{
                        System.out.println("Bakiyeniz yetersiz!!");
                        return false;
                    }
            }
        } else {
            System.out.println("Mağaza Sorunu -> Sayfalama");
            return false;
        }
        System.out.println("Mağaza Sorunu -> Bilinmeyen");
        return false;
    }

    private static String getWeaponType(Character player) {
        return switch (player.getCode()) {
            case "WARR" -> "Kılıç";
            case "ARCH" -> "Yay";
            case "WZRD" -> "Asa";
            default -> "Karakter türünde HATA!!";
        };
    }

    public static String getName() {
        return gameName;
    }
}