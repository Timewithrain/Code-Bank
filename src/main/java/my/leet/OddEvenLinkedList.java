package my.leet;

/** 328. */
public class OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {this.val = val;}
    }

    static ListNode func(ListNode head) {
        ListNode ODD = new ListNode(), o = ODD;
        ListNode EVEN = new ListNode(), e = EVEN;
        ListNode p = head;
        int cnt = 1;
        while (p != null) {
            ListNode q = p;
            p = p.next;
            q.next = null;
            if (cnt%2 != 0) {
                o.next = q;
                o = o.next;
            } else {
                e.next = q;
                e = e.next;
            }
            cnt++;
        }
        o.next = EVEN.next;
        return ODD.next;
    }

    public static void main(String[] args) {
        
    }
}