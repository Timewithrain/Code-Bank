package my.leet;

import my.leet.utils.ListNode;

/** 148. 排序链表 */
public class SortList {

    /** 根据list的取值范围进行表映射 */
    static ListNode func(ListNode head) {
        ListNode HEAD = new ListNode();
        ListNode[] list = new ListNode[200001];
        int offset = 100000;
        ListNode p = head, q = null;
        while (p!=null)  {
            if (list[p.val + offset] == null) {
                q = p;
                p = p.next;
                list[q.val + offset] = q;
                q.next = null;
            } else {
                q = list[p.val + offset];
                while (q.next != null) q = q.next;
                q.next = p;
                p = p.next;
                q.next.next = null;
            }
        }
        for (int i = 0; i < 200001; i++) {
            if (list[i] != null) {
                if (p==null) {
                    p = list[i];
                    HEAD.next = p;
                    while (p.next != null) p = p.next;
                } else {
                    p.next = list[i];
                    q = list[i];
                    while (q.next != null) q = q.next;
                    p = q;
                }
            }
        }
        if (p!=null) p.next = null;
        return HEAD.next;
    }

    public static void main(String[] args) {
        int[] nums = {4,19,14,5,-3,1,8,5,11,15}; // {}; // {-1,5,3,4,0}; // {4,2,1,3}; //
        ListNode head = ListNode.constructLinkedList(nums);
        head = func(head);
        ListNode.printLinkedList(head);
    }
}
