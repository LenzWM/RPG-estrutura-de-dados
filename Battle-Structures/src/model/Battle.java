package model;
import model.entities.Entity;
import structures.*;

public class Battle {
    private int battleID;
    private int turnCounter;
    private Stack defeatOrder;
    private Queue turnOrder;
    private LinkedList participants;


    public Battle(LinkedList participants){
        defeatOrder = new Stack();
        turnOrder = new Queue();
        this.participants = participants;
    }

    public void startBattle(){
        NodeQueue<Entity> current = participants.getHead();
        while(current != null){
            turnOrder.enqueue(current.data);
            current = current.prev;
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
        NodeQueue<Entity> current = turnOrder.getHead();
        while(current != null){
            System.out.println(current.data.getName());
            current = current.prev;
        }
    }

    public void showState(){
        System.out.println("Turn Order: ");
        NodeQueue<Entity> current = turnOrder.getHead();
        while(current != null){
            System.out.println(current.data.getName() + " HP: " + current.data.getCurrentHp() + "/" + current.data.getMaxHp());
            current = current.prev;
        }

        System.out.println();
    }
}
