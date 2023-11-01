package my.leet;

import my.leet.utils.ListNode;

/** 92. 反转链表II */
public class ReverseLinkedListII {

    static ListNode func(ListNode head, int left, int right) {
        ListNode HEAD = new ListNode();
        HEAD.next = head;
        ListNode pre = HEAD, p = head;
        int cnt = 1;
        while (p!=null && cnt < left) {
            p = p.next;
            pre = pre.next;
            cnt++;
        }
        pre.next = null;
        ListNode preTail = p;
        while (p!=null && cnt <= right) {
            ListNode q = p;
            p = p.next;
            q.next = pre.next;
            pre.next = q;
            cnt++;
        }
        if (preTail!=p) preTail.next = p;
        else pre.next = preTail;
        return HEAD.next;
    }

    public static void main(String[] args) {
        int[] nums = {5}; //{1,2,3,4,5}; // {3,5}; //
        ListNode head = ListNode.constructLinkedList(nums);
        ListNode.printLinkedList(head);
        System.out.println("\n---");
        head = func(head, 1, 1);
        ListNode.printLinkedList(head);

    }
}
