package structures;

import model.entities.*;

public class Queue {
    public NodeQueue<Entity> head;
    public NodeQueue<Entity> tail;

    public void enqueue(Entity newEntity){
        NodeQueue<Entity> newNode = new NodeQueue<>(newEntity);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.prev = newNode;
        newNode.next = tail;
        tail = newNode;
    
    }

    public void dequeue(){
        if (isEmpty()){
            return;
        }
        NodeQueue<Entity> temp = head;
        head = head.prev;
        head.next = null;
        temp.prev = null;
    }

    public Entity peekEntity(){
        return  head.data;
    }

    public Boolean isEmpty() {
        return head == null;
    }

}
