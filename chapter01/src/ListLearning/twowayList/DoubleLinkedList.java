package ListLearning.twowayList;

/**
 * @Description: 双向链表的实现
 * @Author: PanYi
 * @Date: 2022/7/28
 */

public class DoubleLinkedList<E> {

    // 头结点
    private Node<E> head;
    // 尾结点
    private Node<E> tail;
    private int size;


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }


    private void linkLast(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(tail, e, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

}
