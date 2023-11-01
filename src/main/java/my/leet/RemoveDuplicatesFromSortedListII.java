package my.leet;

import my.leet.utils.ListNode;

import java.util.HashSet;

/** 82. 删除排序链表中的重复元素II */
public class RemoveDuplicatesFromSortedListII {

    static ListNode func(ListNode head) {
        ListNode HEAD = new ListNode();
        HEAD.next = head;
        ListNode pre = head, p = head!=null ? head.next : null;
        HashSet<Integer> set = new HashSet<>();
        while (p != null) {
            if (pre.val != p.val) {
                pre.next = p;
                pre = pre.next;
            } else {
                set.add(p.val);
            }
            p = p.next;
        }
        if (pre != null) pre.next = p;
        pre = HEAD;
        p = HEAD.next;
        while (p!=null) {
            if (!set.contains(p.val)) {
                pre.next = p;
                pre = pre.next;
            }
            p = p.next;
        }
        pre.next = p;
        return HEAD.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5}; // {1,1,1,2,3}; // {1,1}; //
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head);
        ListNode.printLinkedList(head);
    }
}
