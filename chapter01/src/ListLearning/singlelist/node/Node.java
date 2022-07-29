package ListLearning.singlelist.node;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/28
 */

class Node<E> {
    E item;
    Node next;

    public Node() {
        this.next = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("item=").append(item);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
