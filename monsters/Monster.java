package monsters;

public abstract class Monster {
    private String name;
    private int health;
    private final int maxHealth;
    private int damage;

    Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
    }

    // Getter metotları
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getMaxHealth() { return this.maxHealth; }
    public int getDamage() { return this.damage; }

    // Setter metotları
    public void setHealth(int health) { this.health = health; }
}
