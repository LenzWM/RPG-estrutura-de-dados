public class stack {
    Node head;

    public stack (){
        head = null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop (){
        if(head == null) {return -1;}
        int data = head.data;
        head = head.next;
        return data;
    }

    public int  vazia (){
        if (head == null) return 1;
        return 0;
    }

    public void peek(Node current){
        if (current != null) {
            System.out.println(current.data);
            peek(current.next);
        }
    }

}
