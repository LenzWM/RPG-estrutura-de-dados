package model.entities;

import model.Battle;

public class PlayerCharacter extends Entity {
    private int id;

    public PlayerCharacter(int id, float maxHp, float maxMana, float currentMana, int level, String name) {
        super(maxHp, maxMana, currentMana, level, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        
    }


    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHp(getMaxHp() * 1.1f); // Increase max HP by 10%
        setCurrentHp(getMaxHp()); // Restore current HP to max
        setMaxMana(getMaxMana() * 1.1f); // Increase max Mana by 10%
        setCurrentMana(getMaxMana()); // Restore current Mana to max
    }
}
