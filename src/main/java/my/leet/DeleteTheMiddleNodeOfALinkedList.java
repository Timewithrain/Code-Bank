package my.leet;

import my.leet.utils.ListNode;

import java.util.ArrayList;

/** 2095. 删除链表的中间节点 */
public class DeleteTheMiddleNodeOfALinkedList {

    /** 一次遍历 + 变长列表 */
    static ListNode func(ListNode head) {
        ListNode HEAD = new ListNode(), p = head;
        HEAD.next = head;
        ArrayList<ListNode> arr = new ArrayList<>();
        while (p != null) {
            arr.add(p);
            p = p.next;
        }
        if (arr.size() == 1) return null;
        int mid = arr.size() / 2;
        arr.get(mid-1).next = arr.get(mid).next;
        return HEAD.next;
    }

    /** 两次遍历实现 */
    static ListNode func2(ListNode head) {
        ListNode HEAD = new ListNode(), p = head, q = null;
        HEAD.next = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        q = HEAD;
        p = head;
        int i = 0;
        while (i < n/2) {
            q = p;
            p = p.next;
            i++;
        }
        q.next = p.next;
        return HEAD.next;
    }

    /** 快慢指针实现 */
    static ListNode func3(ListNode head) {
        ListNode HEAD = new ListNode();
        HEAD.next = head;
        ListNode pre = HEAD, fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return HEAD.next;
    }

    public static void main(String[] args){

    }
}
