package model.entities;

public class Entity {
    private float maxHp;
    private float currentHp;
    private float maxMana;
    private float currentMana;
    private int level;
    private String name;

    public Entity(float maxHp, float currentHp, float maxMana, float currentMana, int level, String name) {
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.maxMana = maxMana;
        this.currentMana = currentMana;
        this.level = level;
        this.name = name;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(float maxHp) {
        this.maxHp = maxHp;
    }

    public float getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(float currentHp) {
        this.currentHp = currentHp;
    }

    public float getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(float maxMana) {
        this.maxMana = maxMana;
    }

    public float getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(float currentMana) {
        this.currentMana = currentMana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
