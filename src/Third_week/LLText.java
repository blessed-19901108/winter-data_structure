package Third_week;

public class LLText {
    // insertFront 头插法
    public static <E> void insertF(Node head, E date) {
        Node node = new Node((Comparable) date);
        node.next = head.next;
        head.next = node;
    }

    // insertBehind 尾插法
    public static <E> void insertB(Node tail, E date) {
        Node node = new Node((Comparable) date);
        tail.next = node;
        tail = tail.next;
    }

    public static void main(String[] args) {

    }
}


class Node<T extends Comparable> {
    protected T date;
    /**
     * next实际上是一个对象
     */
    protected Node<T> next;

    Node(T date) {
        this.date = date;
        next = null;
    }

    public T getDate() {
        return date;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
