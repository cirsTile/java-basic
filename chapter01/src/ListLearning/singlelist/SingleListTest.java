package ListLearning.singlelist;

import ListLearning.singlelist.node.SingleList;
import ListLearning.twowayList.DoubleLinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/28
 */

public class SingleListTest {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.add("hello");
        singleList.add("world");
        singleList.add("java");
        singleList.add(1);
        singleList.addAtFirst("Rust");
        singleList.printSingleList();
//        System.out.println("单链表的元素：" + singleList.get(10));
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        List list = new LinkedList();
    }
}
