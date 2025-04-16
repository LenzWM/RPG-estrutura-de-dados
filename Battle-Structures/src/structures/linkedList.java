package structures;

import model.entities.Entity;

public class LinkedList {
    NodeQueue<Entity> head;

    public LinkedList(){
        this.head = null;
    }

    public void add(Entity data){
        NodeQueue<Entity> newNode = new NodeQueue(data);
        newNode.next = head;
        head = newNode;
    }

    public void pop(){
        
    }

    public NodeQueue<Entity> peek(){
        if (head == null){
            System.out.println("ERROR: LINKED LIST IS EMPTY, IMPOSSIBLE TO PEEK");
            return null;
        }
        return head;
    }
}
