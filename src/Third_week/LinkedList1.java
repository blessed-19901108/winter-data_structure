package Third_week;

/**
 * 使用泛型方法实现
 */
public class LinkedList1 {
    /**
     * 链表中的节点模型
     */
    static class Node<T extends Comparable> {
        private T date;
        /**
         * next实际上是一个对象
         */
        private Node next;

        Node(T date) {
            this.date = date;
            next = null;
        }

        public T getDate() {
            return date;
        }

        public Node getNext() {
            return next;
        }

        public void setDate(T date) {
            this.date = date;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public Node head;
    public Node tail;

    /**
     * 头节点 构造方法
     * 此时的头节点相当于辅助节点，辅助节点date值自己定，next值为我们输入的值
     * 因为前面已经声明了public Node head; 所以head值默认为null
     * (补充：只是声明了一个变量，而不new一个对象的话，那么它只是一个没有指向
     * 任何地方的指针(根据编译环境的不同可能会置为空))
     * 所以在构造方法中不可以直接写head.date = -1，要new一个节点才可以
     * 但是尾部是“真正的”尾部，是我们输入的值，所以尾部实际上应该是头节点的next
     */
    public LinkedList1(Node node) {
        head = new Node(null);
        head.next = node;
        tail = head.next;
    }

    /**
     * insertFront 头插法
     */
    public <E extends Comparable> void insertF(E date) {
        Node node = new Node<E>(date);
        node.next = head.next;
        head.next = node;
    }

    /**
     * insertRear 尾插法
     */
    public <E extends Comparable> void insertR(E date) {
        Node node = new Node<E>(date);
        tail.next = node;
        tail = tail.next;
    }

    /**
     * 打印所有节点的数据
     */
    public void printAllNodes() {
        //头节点的数据为null
        Node p = head.next;
        while (p != null) {
            System.out.print(p.date + "  ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList1 l1 = new LinkedList1(new Node(a[0]));
        int i = 1;
        while (i < a.length) {
            l1.insertF(a[i]);
//            l1.insertR(a[i]);
            i++;
        }
        l1.printAllNodes();
    }

}
