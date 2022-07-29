package tree;

/**
 * @Description: 树节点的定义
 * @Author: PanYi
 * @Date: 2022/7/29
 */

public class TreeNode<E> {

    public E data;

    public TreeNode<E> left;

    public TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
    }

}
