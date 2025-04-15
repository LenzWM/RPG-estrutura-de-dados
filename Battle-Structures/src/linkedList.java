public class linkedList {
    Node head;

    public linkedList(){
        this.head = null;
    }

    public void insertiIn(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void isertTheEnd (Node current, int data){
        if (current == null) {
            head = new Node(data);
        } else if (current.next == null) {
            current.next = new Node(data);
        } else {
            isertTheEnd(current.next, data);
        }
    }

    public void peek(Node current){
        if (current != null) {
            System.out.println(current.data);
            peek(current.next);
        }
    }
}
