package model.entities;
import model.Battle;

public class Enemie extends Entity{
    public Enemie(String name, int level, float maxHp,  float maxMana, float currentMana) {
        super(maxHp, maxMana, currentMana, level, name);
    }
    
    @Override
    public void attack(Entity target) {
        if (target == null) {
            throw  new RuntimeException(getName() + " tried to attack a null target.");
        }

        System.out.println(getName() + " attacks " + target.getName() );
    }

    @Override
    public boolean isAlive() {
        return getCurrentHp() > 0;
    }

    @Override
    public void takeTurn(Battle battle) {
        System.out.println(getName() + "'s turn!");
        // Implement enemy AI logic here
    }
}
