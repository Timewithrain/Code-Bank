package my.exam.ccb;

import my.leet.utils.ListNode;

import java.util.HashMap;

/**
 * 1. 删除链表节点
 * 给定一个链表，删除多余的节点使链表中的节点值全部相等，要求删除的次数最少，返回节点值全部相同的最长链表
 * 输入：
 * {1, 2, 2, 3, 5, 1}
 * 输出：
 * {1,1} 或 {2,2} (有多个结果返回其一即可)
 */
public class DeleteListNode {

    public ListNode solve (ListNode head) {
        ListNode HEAD = new ListNode(-1);
        ListNode p = head, q = HEAD;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        while (p!=null) {
            map.put(p.val, map.getOrDefault(p.val, 0)+1);
            if (map.get(p.val) > map.getOrDefault(maxVal, 0)) {
                maxVal = p.val;
            }
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (p.val == maxVal) {
                q.next = p;
                q = q.next;
            }
            p = p.next;
        }
        q.next = null;
        return HEAD.next;
    }

    public static void main(String[] args){

    }
}
