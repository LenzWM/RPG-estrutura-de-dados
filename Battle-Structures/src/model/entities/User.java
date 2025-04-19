package model.entities;
import structures.*;

public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private PlayerCharacter playerCharacter;
    private LinkedListOur personagens;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.email = ""; // Define um valor padrão para o email
        this.playerCharacter = null;
        personagens = new LinkedListOur();

    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.playerCharacter = null;
        personagens = new LinkedListOur();
    }

    public void criarPersonagem(String nome) {
        int id = personagens.getSize() + 1;
        int level = 1;
        int vidaBase = 500;
        int manaBase = 30;
        int damage = 60;
        PlayerCharacter novoPersonagem = new PlayerCharacter(id, vidaBase, manaBase, manaBase, level, nome, damage);
        // public PlayerCharacter(int id, float maxHp, float maxMana, float currentMana, int level, String name, int damage) {
        personagens.addTail(novoPersonagem);
        
        if (personagens.getHead() == null) {
            playerCharacter= novoPersonagem;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }
    
    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public LinkedListOur getPersonagens() {
        return personagens;
    }

    public void setPersonagens(LinkedListOur personagens) {
        this.personagens = personagens;
    }

}
