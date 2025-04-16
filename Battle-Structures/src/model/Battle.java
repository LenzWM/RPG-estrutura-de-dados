package model;
import Others.ClearConsole;
import model.entities.*;
import structures.*;

public class Battle {
    private int battleID;
    private int turnCounter;
    private Stack defeatOrder;
    private Queue turnOrder;
    private LinkedList participants;
    private boolean playerWon;


    public Battle(LinkedList participants){
        defeatOrder = new Stack();
        turnOrder = new Queue();
        this.participants = participants;
    }

    public void startBattle(){
        Node<Entity> current = participants.getHead();
        while(current != null){
            turnOrder.enqueue(current.data);
            current = current.prev;
        }

        while (!isBattleOver()){
            ClearConsole.clear();
            turnCounter++;
            System.out.print("Turn " + turnCounter + ": ");
            executeTurn();
        }
        
        if (playerWon) {
            System.out.println("You won! But at what cost?.");
            System.out.println("No mental sanity remaining.");
            
        }else {
            System.out.println("> GAME OVER <");
        }
        
    }

    public void executeTurn(){
        //dequeue turnorder head, check if their alive, execute their turn, enqueue them again
        Entity current = turnOrder.dequeue();
        if (current.isAlive()){
            current.takeTurn(this);
            if (current.isAlive()){
                turnOrder.enqueue(current);
            } else {
                defeatOrder.push(current);
            }
        } else {
            defeatOrder.push(current);
        }
    }

    public void showTurnOrder(){
        System.out.println("Turn Order: ");
        Node<Entity> current = turnOrder.getHead();
        while(current != null){
            System.out.println(current.data.getName());
            current = current.prev;
        }
    }

    public void showState(){
        System.out.println("Turn Order: ");
        Node<Entity> current = turnOrder.getHead();
        int i = 1;
        while(current != null){
            System.out.println(i + ": " +current.data.getName() + " HP: " + current.data.getCurrentHp() + "/" + current.data.getMaxHp());
            current = current.prev;
            i++;
        }
        
        showDefeatOrder();

        System.out.println();
    }

    public void showDefeatOrder(){
        System.out.println("Defeated: ");
        NodeStack<Entity> current = defeatOrder.getHead();
        while(current != null){
            System.out.println(current.data.getName() + ": DEFEATED" );
            current = current.prev;
        }
    }

    public boolean isBattleOver(){
        Node<Entity> current = participants.getHead();
        int counter = 0;
        while(current != null){
            if (current.data.isAlive()){
                counter++;
            }
            if (current.data instanceof PlayerCharacter && !current.data.isAlive()){
                playerWon = false;
                return true;
            }
            
            current = current.prev;
        }
        if (counter == 0 || counter == 1){
            playerWon = true;
            return true;
        }
        return false;
    }

    public int getBattleID() {
        return battleID;
    }

    public void setBattleID(int battleID) {
        this.battleID = battleID;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public Stack getDefeatOrder() {
        return defeatOrder;
    }

    public void setDefeatOrder(Stack defeatOrder) {
        this.defeatOrder = defeatOrder;
    }

    public Queue getTurnOrder() {
        return turnOrder;
    }

    public void setTurnOrder(Queue turnOrder) {
        this.turnOrder = turnOrder;
    }

    public LinkedList getParticipants() {
        return participants;
    }

    public void setParticipants(LinkedList participants) {
        this.participants = participants;
    }

    
}
