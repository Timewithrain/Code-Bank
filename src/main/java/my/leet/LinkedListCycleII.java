package my.leet;

import my.leet.utils.ListNode;

import java.util.HashSet;

/**
 * 141. 环形链表II
 */
public class LinkedListCycleII {

    /** 标准解法: 快慢指针法(二次相遇) */
    static ListNode func(ListNode head) {
        ListNode ans = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && slow!=null) {
            fast = fast.next;
            slow = slow.next;
            if (fast!=null) fast = fast.next;
            if (fast!=null && fast==slow) {  // 快慢指针第一次相遇
                fast = head;
                while (fast!=slow) {  // 快慢指针第二次相遇
                    fast = fast.next;
                    slow = slow.next;
                }
                ans = fast;
                break;
            }
        }
        return ans;
    }

    /** 使用HashSet记录节点的hash code用于判断是否访问过 */
    static ListNode func1(ListNode head) {
        ListNode ans = null;
        HashSet<Integer> set = new HashSet<>();
        while(head!=null) {
            if (set.contains(head.hashCode())) {
                ans = head;
                break;
            } else {
                set.add(head.hashCode());
            }
            head = head.next;
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
        int[] nums = {3,2,0,-4};
        ListNode head = ListNode.constructLinkedList(nums);
        makeCycle(head, 3);
        ListNode ans = func(head);
        if (ans!=null)
            System.out.println(ans.val);
        else
            System.out.println(ans);
    }

}
