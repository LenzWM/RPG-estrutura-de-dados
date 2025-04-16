package structures;

import model.entities.*;

public class Queue {
    private NodeQueue<Entity> head;
    private NodeQueue<Entity> tail;

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

    public Entity dequeue(){
        if (isEmpty()){
            throw  new RuntimeException("Queue is empty. Cannot dequeue.");
        }
        NodeQueue<Entity> temp = head;
        head = head.prev;
        head.next = null;
        temp.prev = null;

        return  temp.data;
    }

    public Entity peekEntity(){
        return  head.data;
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public NodeQueue<Entity> getHead() {
        return head;
    }

    public void setHead(NodeQueue<Entity> head) {
        this.head = head;
    }

    public NodeQueue<Entity> getTail() {
        return tail;
    }

    public void setTail(NodeQueue<Entity> tail) {
        this.tail = tail;
    }

}
