package my.leet;

import my.leet.utils.ListNode;

/** 19. 删除链表倒数第N个节点 */
public class RemoveNthNodeFromEndOfList {

    static ListNode func(ListNode head, int n) {
        ListNode FAKE = new ListNode();  // 使用一个FAKE节点作为头节点，消除操作差异
        FAKE.next = head;
        ListNode p = FAKE;
        ListNode node = FAKE;
        int i = n;
        while (i-- > 0) { // node先遍历n个节点
            node = node.next;
        }
        while (node.next != null) {
            node = node.next;  //  node从第n个节点遍历至末尾
            p = p.next;  // 同时p也从头节点开始遍历至倒数第n个节点的前一个结点
        }
        if (p != FAKE) {
            node = p.next.next;
            p.next = node;
        } else {
            FAKE.next = FAKE.next.next;
        }
        return FAKE.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int n = 3;
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head, n);
        ListNode.printLinkedList(head);
    }
}
