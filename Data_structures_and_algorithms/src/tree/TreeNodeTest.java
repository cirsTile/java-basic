package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 测试树节点
 * @Author: PanYi
 * @Date: 2022/7/29
 */

public class TreeNodeTest {
    public static void main(String[] args) {

        System.out.println("=================前序遍历==================");
        preOrderPrint(buildTree());
        System.out.println("=================中序遍历==================");
        inOrderPrint(buildTree());
        System.out.println("=================后序遍历==================");
        backOrderPrint(buildTree());

        Set set = new HashSet();

    }

    // 创建树
    public static TreeNode buildTree() {
        // 创建测试用的二叉树
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t7;
        t3.left = t5;
        t3.right = t6;
        t6.left = t8;

        return t1;
    }

    // 前序遍历
    public static void preOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println("Tree data is " + root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }


    // 中序遍历：先遍历左节点，再遍历右节点
    public static void inOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderPrint(root.left);
        System.out.println("Tree data is " + root.data);
        inOrderPrint(root.right);
    }


    // 后序遍历：先打印右节点，再打印左节点
    public static void backOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        backOrderPrint(root.left);
        backOrderPrint(root.right);
        System.out.println("Tree data is " + root.data);
    }

}
