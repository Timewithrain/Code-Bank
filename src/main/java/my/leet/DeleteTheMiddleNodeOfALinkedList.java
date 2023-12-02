package my.leet;

import my.leet.utils.ListNode;

import java.util.ArrayList;

/** 2095. 删除链表的中间节点 */
public class DeleteTheMiddleNodeOfALinkedList {

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

    public static void main(String[] args){

    }
}
