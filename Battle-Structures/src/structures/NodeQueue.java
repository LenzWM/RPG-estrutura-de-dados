package structures;

public class NodeQueue<T> {
    public NodeQueue<T> next;
    public NodeQueue<T> prev;
    public T data;

    public NodeQueue(T data){
        next = null;
        prev = null;
        this.data = data;
    }
}
