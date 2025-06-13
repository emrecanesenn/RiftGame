package characters;

public class Wizard extends Character{
   final int defaultDamage = 12;
   public Wizard(String characterType, String characterCode, String characterName) {
      super(characterType, characterCode, characterName, 80);
   }

   @Override
   public void initializeStats(){
      this.setHeal(80);
      this.setDamage(defaultDamage);
      setDefaultDamage(defaultDamage);
      this.setMoney(80);
      this.setWeapon("Basit Asa");
   }
}