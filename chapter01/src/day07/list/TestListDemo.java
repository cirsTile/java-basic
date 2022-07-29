package day07.list;


import day07.listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/6
 */

public class TestListDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(0);
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(0));
        System.out.println("===============================");
        ListNode listNode = myLinkedList.head.next;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        Set set = new HashSet();
    }
}
