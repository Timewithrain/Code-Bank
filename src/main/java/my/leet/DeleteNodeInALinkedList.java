package my.leet;

import my.leet.utils.ListNode;

/** 203. 移除链表中的节点 */
public class DeleteNodeInALinkedList {

    static void func(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
