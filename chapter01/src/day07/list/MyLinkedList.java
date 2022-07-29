package day07.list;

import day07.listnode.ListNode;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/6
 */

public class MyLinkedList {

    int size;
    ListNode head;

    // 调用构造器初始化的时候，创建头节点
    public MyLinkedList() {
        size = 0;
        head = new ListNode();
    }

    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        // 循环移动到第 index 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        if (head.next == null){
            head.next = new ListNode(val);
        }else {
            ListNode newNode = new ListNode(val);
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    // 将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        if (head.next == null) {
            head.next = new ListNode(val);
        }else {
            ListNode newNode = new ListNode(val);
            ListNode temp = head.next;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // 在链表中的第 index 个节点之前添加值为 val  的节点。
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index >= size) {
            return;
        }
        // 找到要插入的前驱节点
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    // deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}
