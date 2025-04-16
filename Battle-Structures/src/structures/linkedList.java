package structures;

import model.entities.Entity;

public class LinkedList {
    private NodeQueue<Entity> head;
    private NodeQueue<Entity> tail;


    public LinkedList(){
        head = null;
        tail = null;
    }

    public void addTail(Entity data){
        NodeQueue<Entity> newNode = new NodeQueue<>(data);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.prev = newNode;
        newNode.next = tail;
        tail = newNode;
    }

    public Entity pop(){
        if (isEmpty()){
            throw new RuntimeException("List is empty. Cannot pop.");
        }
        if (head == tail){
            Entity temp = head.data;
            head = null;
            tail = null;
            return temp;
        }
        
        NodeQueue<Entity> temp = head;
        head = head.prev;
        head.next = null;
        temp.prev = null;

        return temp.data;

    }

    public NodeQueue<Entity> peek(){
        if (isEmpty()){
            throw new RuntimeException("List is empty. Cannot peek.");
        }
        return head;
    }

    public Boolean isEmpty(){
        return head==null;
    }

    public NodeQueue<Entity> getHead() {
        return head;
    }

    public void setHead(NodeQueue<Entity> head) {
        this.head = head;
    }

}
