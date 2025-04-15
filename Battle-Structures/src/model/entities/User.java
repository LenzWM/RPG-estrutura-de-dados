package model.entities;

public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private PlayerCharacter playerCharacter;

    public User(int id, String userName, String password, String email, PlayerCharacter playerCharacter) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.playerCharacter = playerCharacter;
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
}
