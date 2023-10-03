package my.leet;

import my.leet.utils.ListNode;

public class MergeTwoSortedLists {

    static ListNode func(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        while (list1!=null && list2!=null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
            p.next = null;
        }
        if (list1!=null) p.next = list1;
        if (list2!=null) p.next = list2;
        return ans.next;
    }

    public static void main(String[] args) {

    }
}
