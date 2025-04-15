package model.entities;

public class Enemies extends Entity{
    private String name;
    private int level;
    private float maxHp;
    private float currentHp;
    private float maxMana;
    private float currentMana;

    public Enemies(String name, int level, float maxHp, float currentHp, float maxMana, float currentMana) {
        super(maxHp, currentHp, maxMana, currentMana, level, name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public float getMaxHp() {
        return maxHp;
    }

    @Override
    public void setMaxHp(float maxHp) {
        this.maxHp = maxHp;
    }

    @Override
    public float getCurrentHp() {
        return currentHp;
    }

    @Override
    public void setCurrentHp(float currentHp) {
        this.currentHp = currentHp;
    }

    @Override
    public float getMaxMana() {
        return maxMana;
    }

    @Override
    public void setMaxMana(float maxMana) {
        this.maxMana = maxMana;
    }

    @Override
    public float getCurrentMana() {
        return currentMana;
    }

    @Override
    public void setCurrentMana(float currentMana) {
        this.currentMana = currentMana;
    }
    
    
}
