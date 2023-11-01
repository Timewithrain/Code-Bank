package my.leet;

import my.leet.utils.ListNode;

/** 86. 分隔链表 */
public class PartitionList {

    static ListNode func(ListNode head, int x) {
        ListNode HEAD = new ListNode();
        ListNode pre = HEAD, p = head;
        HEAD.next = head;
        while (p!= null && p.val < x) {
            pre = pre.next;
            p = p.next;
        }
        ListNode neck = pre;
        pre = p;
        if (p!=null) p = p.next;
        while (p != null) {
            if (p.val < x) {
                ListNode q = p;
                p = p.next;
                q.next = neck.next;
                neck.next = q;
                neck = neck.next;
                pre.next = p;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }
        return HEAD.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,0,2,5,2}; // {2,1,1}; // {1,4,3,2,5,2}; //
        int x = 3; // 2; //
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head, x);
        ListNode.printLinkedList(head);
    }
}
