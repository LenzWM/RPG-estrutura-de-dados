package model.entities;

public class Enemies extends Entity{

    public Enemies(String name, int level, float maxHp, float currentHp, float maxMana, float currentMana) {
        super(maxHp, currentHp, maxMana, currentMana, level, name);
    }
}
