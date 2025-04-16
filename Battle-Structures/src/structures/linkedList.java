package structures;

import model.entities.Entity;

public class LinkedList {
    private Node<Entity> head;
    private Node<Entity> tail;


    public LinkedList(){
        head = null;
        tail = null;
    }

    public void addTail(Entity data){
        Node<Entity> newNode = new Node<>(data);
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
        
        Node<Entity> temp = head;
        head = head.prev;
        head.next = null;
        temp.prev = null;

        return temp.data;

    }

    public Entity getItemByIndex(int index) {
        if (isEmpty()){
            throw new RuntimeException("List is empty. Cannot get item by index.");
        }
        Node<Entity> current = head;
        for (int i = 0; i < index; i++){
            if (current == null){
                throw new RuntimeException("Index out of bounds.");
            }
            current = current.prev;
        }
        return current.data;
    }

    public Node<Entity> peek(){
        if (isEmpty()){
            throw new RuntimeException("List is empty. Cannot peek.");
        }
        return head;
    }

    public Boolean isEmpty(){
        return head==null;
    }

    public Node<Entity> getHead() {
        return head;
    }

    public void setHead(Node<Entity> head) {
        this.head = head;
    }

}
