package model.entities;

public class PlayerCharacter extends Entity {

    private int id;
    
    public PlayerCharacter(int id, float maxHp, float currentHp, float maxMana, float currentMana, int level, String name) {
        super(maxHp, currentHp, maxMana, currentMana, level, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
