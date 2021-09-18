package Third_week;

/**
 * 使用泛型类实现
 */
class node<T> {
    T data;
    node<T> next;

    /**
     * 两个构造方法
     * 无参构造头节点，有参构造普通节点
     */
    public node() {
        next = null;
    }

    public node(T data) {
        this.data = data;
        next = null;
    }
}

/**
 * 链表类，不用static的话，直接创建该类的一个对象使用
 */
public class LinkedList2<T> {
    node<T> head;

    public LinkedList2() {
        head = new node<T>();
        head.next = null;
    }

    /**
     * 头插法
     * 链表类中的头插法，也就是说已经存在了一个链表，因为链表的无参构造方法
     * 已经创建了头节点，同时链表类中的属性也有head，所以在使用头插法时可
     * 以直接使用该链表类的head
     * 最好不要在方法中直接赋确定的值，一般方法都是处理业务逻辑的，在此方法
     * 中如果要一边创建节点，一边把i赋值给节点的话，就要明确所有有关的T，但
     * 是head属性在该链表类中没有传入参数的方法，所以没有办法改变head的数
     * 据类型
     */
    public void createList(T[] arr) {
        int i = 0;
        while (i < arr.length) {
            //每插入一个数据就创建一个节点
            node<T> node = new node<T>(arr[i]);
            node.next = head.next;
            head.next = node;
            i++;
        }
    }

    /**
     * 打印输出链表
     */
    public void printAllNodes() {
        //头节点的数据为null
        node p = head.next;
        while (p != null) {
            System.out.print(p.data + "  ");
            p = p.next;
        }
    }


    public static void main(String[] args) {
        LinkedList2<Integer> l1 = new LinkedList2<Integer>();
        Integer[] arr = {0, 1, 2, 3, 4, 5};
        l1.createList(arr);
        l1.printAllNodes();
    }
}
