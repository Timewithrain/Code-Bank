package my.leet;

import my.leet.utils.ListNode;

/**
 * 160. 相交链表
 */
public class IntersectionOfTwoLinkedLists {

    static ListNode func(ListNode headA, ListNode headB) {
        int lA = 0;
        int lB = 0;
        ListNode A = headA;
        ListNode B = headB;
        ListNode ans = null;
        while (A!=null || B!=null) {
            if (A!=null) {
                lA += 1;
                A = A.next;
            }
            if (B!=null) {
                lB += 1;
                B = B.next;
            }
        }
        int dis = lA - lB;
        if (dis>0) {
            while (dis>0) {
                headA = headA.next;
                dis--;
            }
        } else {
            while(dis<0) {
                headB = headB.next;
                dis++;
            }
        }
        while (headA!=null && headB!=null) {
            if (headA==headB) {
                ans = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return ans;
    }

}
