package my.exam.qunaer;

import my.leet.utils.ArrayUtils;

import java.util.HashMap;

/**
 * 3. 计算链表的长度，需要考虑去除重复元素
 *
 *
 */
public class LinkedListLength {

    static int lengthL(ListNode head) {
        if (head==null) return 0;
        int n = 1;
        ListNode node = head.next;
        while (node!=null) {
            node = node.next;
            n++;
        }
        return n;
    }

    static int lengthL2(ListNode head) {
        if (head==null) return 0;
        int n = 1;
        ListNode node = head.next;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(head.val, 1);
        while (node!=null) {
            if (map.containsKey(node.val)) {
                map.put(node.val, map.get(node.val) + 1);
            } else {
                map.put(node.val, 1);
            }
            node = node.next;
            n++;
        }
        int rest = 0;
        for (Integer i : map.keySet()) {
            rest += map.get(i) - 1;
        }
        return n - rest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};

    }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
