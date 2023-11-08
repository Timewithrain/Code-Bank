package my.leet;

import my.leet.utils.ListNode;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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

    /** 使用TreeMap排序+链表解决val重复+头尾指针 */
    static ListNode func2(ListNode head) {
        ListNode HEAD = new ListNode();
        ListNode p = head, q = null;
        TreeMap<Integer, ListNode[]> map = new TreeMap<>();
        while (p!=null) {
            q = p;
            p = p.next;
            if (map.containsKey(q.val)) {
                ListNode[] tmp = map.get(q.val);  // 出现重复val的节点时，构造链表存储所有val相同的节点，使用数组存放链表的头尾指针
                tmp[1].next = q;
                q.next = null;
                tmp[1] = q;
            } else {
                map.put(q.val, new ListNode[]{q, q});  // 未遇到重复val时，初始化数组，头尾指针指向同一个节点
                q.next = null;
            }
        }
        for (Map.Entry<Integer, ListNode[]> entry : map.entrySet()) {
            if (HEAD.next == null) {
                HEAD.next = entry.getValue()[0];
            } else {
                p.next = entry.getValue()[0];
            }
            p = entry.getValue()[1];
        }
        if (p != null) p.next = null;
        return HEAD.next;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,3}; // {-1,5,3,4,0}; // {}; // {4,19,14,5,-3,1,8,5,11,15}; //
        ListNode head = ListNode.constructLinkedList(nums);
        head = func2(head);
        ListNode.printLinkedList(head);
    }
}
