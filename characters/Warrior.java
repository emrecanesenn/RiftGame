package characters;

public class Warrior extends Character{
   final int defaultDamage = 15;

   public Warrior(String characterType, String characterCode, String characterName) {
      super(characterType, characterCode, characterName, 120);
   }

   @Override
   public void initializeStats(){
      this.setHeal(120);
      this.setDamage(defaultDamage);
      setDefaultDamage(defaultDamage);
      this.setMoney(50);
      this.setWeapon("El");
   }
}
