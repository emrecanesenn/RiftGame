package characters;

public class Archer extends Character{
   final int defaultDamage = 18;
   public Archer(String characterType, String characterCode, String characterName) {
      super(characterType, characterCode, characterName, 100);
   }

   @Override
   public void initializeStats(){
      this.setHeal(100);
      this.setDamage(defaultDamage);
      setDefaultDamage(defaultDamage);
      this.setMoney(60);
      this.setWeapon("Basit Yay");
   }

   public int getDefaultDamage() { return defaultDamage; }
}