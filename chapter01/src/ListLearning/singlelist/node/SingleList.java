package ListLearning.singlelist.node;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/28
 */

public class SingleList<E> {

    private Node<E> head;
    private int size;

    /**
     * @Description:提供一个构造函数，并且提供头节点的初始化
     */
    public SingleList() {
        this.head = new Node<>();
        this.size = 0;
    }


    /**
     * 添加节点到链表的第一位
     * @param item
     * @param <E>
     * @return
     */
    public <E> boolean addAtFirst(E item) {
        Node<E> node = new Node<>();
        node.item = item;
        node.next = this.head.next;
        this.head.next = node;
        size++;
        return true;
    }

    public <E> boolean add(E item) {
        Node<E> node = new Node<>();
        node.item = item;
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
        return true;
    }


    /**
     * 打印链表
     */
    public void printSingleList() {
        Node node = this.head;
        while (node.next != null) {
            System.out.println(node.next.item);
            node = node.next;
        }
        System.out.println("单链表的长度为：" + this.size);
    }



    private boolean isIndexValid(int index) {
        return index >= 0 && index < this.size;
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        return true;
    }


    public E get(int index) {
        checkIndex(index);
        Node<E> node = this.head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.item;
    }


}
