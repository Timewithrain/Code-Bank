package my.leet.utils;

public class ListNode {

    public Integer val;

    public ListNode next;

    public ListNode() {};

    public ListNode(Integer value) {
        this.val = value;
        this.next = null;
    }

    public static ListNode constructLinkedList(int[] nums) {
        ListNode head = null;
        ListNode node = null;
        ListNode pre = null;
        for (int i = 0; i < nums.length; i++) {
            node = new ListNode(nums[i]);
            if (i>0)
                pre.next = node;
            else
                head = node;
            pre = node;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node!=null) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
    }
}
