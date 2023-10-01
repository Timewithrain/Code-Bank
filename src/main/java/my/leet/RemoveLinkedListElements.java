package my.leet;

import my.leet.utils.ListNode;

/** 203. 移除链表元素 */
public class RemoveLinkedListElements {

    static ListNode func(ListNode head, int val) {
        if (head==null) return null;
        head.next = func(head.next, val);
        if (head.val == val) return head.next;
        else return head;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int val = 6;
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head, val);
        ListNode.printLinkedList(head);
    }
}
