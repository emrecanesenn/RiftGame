package characters;

public abstract class Character {
    private final String name;
    private final String type;
    private final String code;
    private String weapon; // Zırh ve silah eklendiği için String oldu
    private int damage;
    private int defaultDamage = 0;
    private String armor = "Yok"; // Zırhın adı
    private int armorDurabilty = 0; // Zırhın canı/blok değeri
    private int heal;
    private final int maxHealth; // Maksimum can (iyileşme için)
    private int money;
    private String location = "None"; // Oyuncunun mevcut konumu

    Character(String characterType, String characterCode, String characterName, int maxHealth) {
        this.type = characterType;
        this.code = characterCode;
        this.name = characterName;
        this.maxHealth = maxHealth;
    }
    public abstract void initializeStats(); // Başlangıç istatistiklerini alt sınıfta ayarlar

    // Getter metotlar
    public String getName() { return name; }
    public String getType() { return type; }
    public String getCode() { return code; }
    public String getWeapon() { return weapon; }
    public int getDamage() { return damage; }
    public String getArmor() { return armor; }
    public int getArmorDurabilty() { return armorDurabilty; }
    public int getHeal() { return heal; }
    public int getMaxHealth() { return maxHealth; }
    public int getMoney() { return money; }
    public String getLocation() { return location; }
    public int getDefaultDamage() { return defaultDamage; }

    // Setter metotlar
    public void setWeapon(String weapon) { this.weapon = weapon; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setArmor(String armor) { this.armor = armor; }
    public void setArmorDurabilty(int armorDurabilty) { this.armorDurabilty = armorDurabilty; }
    public void setHeal(int heal) { this.heal = heal; }
    public void setMoney(int money) { this.money = money; }
    public void setLocation(String location) { this.location = location; }
    public void setDefaultDamage(int defaultDamage) { this.defaultDamage = defaultDamage; }
}