package my.leet;

import my.leet.utils.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveLastNElement {

    static ListNode regression(ListNode head, int i, int l, int n) {
        if (n==l) return head.next;  // 特殊情况，删除第一个节点
        if (l-i == n) {
            head.next = head.next.next;
        } else {
            head.next = regression(head.next, i+1, l, n);
        }
        return head;
    }

    // 递归法，先计算链表长度，再递归删除
    static ListNode func1(ListNode head, int n) {
        int l = 0;
        ListNode node = head;
        while (node!=null) {
            node = node.next;
            l += 1;
        }
        head = regression(head, 1, l, n);
        return head;
    }

    // 双指针法(快慢指针法)，快指针先走n步，然后快慢指针一起走，快指针到达尾部时，慢指针指向倒数第n个节点
    static ListNode func2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = fast;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast==null) return head.next;  // 特殊情况，删除第一个节点
        while (fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = ListNode.constructLinkedList(nums);
        head = func2(head, 3);
        ListNode.printLinkedList(head);
    }
}
