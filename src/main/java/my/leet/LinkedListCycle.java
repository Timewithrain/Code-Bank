package my.leet;

import my.leet.utils.ListNode;

/**
 * 141. 环形链表
 */
public class LinkedListCycle {

    /** 快慢指针法 */
    static boolean func(ListNode head) {
        if (head==null) return false;
        boolean ans = false;
        ListNode fast = head;
        ListNode slow = head;
        while (slow!=null && fast!=null) {
            fast = fast.next;
            slow = slow.next;
            if (fast!=null) fast = fast.next;
            if (fast!=null && fast == slow) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    static void makeCycle(ListNode head, int pos) {
        int i = 1;
        ListNode target = null;
        while (head!=null) {
            if (i==pos) {
                target = head;
            }
            if (head.next==null) {
                break;
            }
            head = head.next;
            i++;
        }
        head.next = target;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.constructLinkedList(nums);
        makeCycle(head, 3);
        boolean ans = func(head);
        System.out.println(ans);

    }
}
