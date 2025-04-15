public class queue {
    Node head, tail;


    public queue (){
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void dequeue(){
        if (head == null) 
            {return; }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
            return;
        }
    }

    public int vazia(){
        if (head == null) return 1;
        return 0;
    }


}
