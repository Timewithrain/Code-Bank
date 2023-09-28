package my.leet;

import my.leet.utils.ListNode;
import java.util.ArrayList;

/**
 * 24. 交换链表节点
 */
public class SwapNodesInPairs {

    /** 标准实现 */
    static ListNode func(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;
        while (node!=null && node.next!=null) {
            next = node.next;
            node.next = next.next;
            next.next = node;
            if (pre!=null) pre.next = next;
            if (head==node) head = next;
            pre = node;
            node = node.next;
        }
        return head;
    }

    /** 借助Array实现 */
    static ListNode func1(ListNode head) {
        if(head==null) return head;
        ArrayList<ListNode> lst = new ArrayList<>();
        while (head!=null) {
            lst.add(head);
            head = head.next;
        }
        for (int i = 0; i < lst.size(); i++) {
            if (i%2==1) {
                ListNode tmp = lst.get(i-1);
                lst.set(i-1, lst.get(i));
                lst.set(i, tmp);
            }
        }
        for (int i = 1; i < lst.size(); i++) {
            lst.get(i-1).next = lst.get(i);
        }
        lst.get(lst.size()-1).next = null;
        return lst.get(0);
    }

    static ListNode func2(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode tmp = head.next;
        head.next = func2(tmp.next);
        tmp.next = head;
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head);
        ListNode.printLinkedList(head);
    }
}
