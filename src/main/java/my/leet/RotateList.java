package my.leet;

import my.leet.utils.ListNode;

/** 61. 旋转链表 */
public class RotateList {

    static ListNode func(ListNode head, int k) {
        ListNode HEAD = new ListNode();
        HEAD.next = head;
        ListNode p = head, tail = HEAD;
        int len = 0;
        while (p!=null) {
            p = p.next;
            tail = tail.next;
            len++;
        }
        if (len==0 || k%len==0) return head;
        int mov = len - (k % len);
        p = HEAD;
        while (mov>0) {
            p = p.next;
            mov--;
        }
        tail.next = HEAD.next;
        HEAD.next = p.next;
        p.next = null;
        return HEAD.next;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2}; // {1}; // {1,2}; // {1,2,3,4,5}; //
        int k = 5; // 2;  //
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head, k);
        ListNode.printLinkedList(head);
    }
}
