package my.exam.tencent2;

import my.leet.utils.ListNode;

import java.util.ArrayList;

/**
 * 牛妹有一堆杂乱无章的数链，牛妹想整理一下这些数链使之从小到大为一个数链
 * 通过: 80%
 */
public class NiuNumberChains {

    static ListNode[] sort(ListNode[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            ArrayList<ListNode> list = new ArrayList<>();
            ListNode node = a[i];
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            list.sort((o1, o2) -> o1.val - o2.val);
            for (int j = 0; j < list.size(); j++) {
                list.get(j).next = (j==list.size()-1) ? null : list.get(j+1);
            }
            a[i] = list.get(0);
        }
        return a;
    }

    static ListNode func(ListNode[] a){
        int n = a.length;
        a = sort(a);
        ListNode head = null;
        ListNode node = a[0];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (node.val > a[i].val) {
                node = a[i];
                idx = i;
            }
        }
        head = node;
        a[idx] = a[idx].next;
        ListNode main = head;
        while (true) {
            idx = 0;
            node = a[0];
            for (int i = 1; i < n; i++) {
                if ((node==null && a[i]!=null) || (node!=null && a[i]!=null && node.val > a[i].val)) {
                    node = a[i];
                    idx = i;
                }
            }
            if (node == null) {
                break;
            }
            if (a[idx] != null) {
                a[idx] = a[idx].next;
            }
            main.next = node;
            main = main.next;
            main.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1000000000}; // {32,1,3,5}; // {1, 4, 5}; //
        int[] b = {1000000000}; // {4,2,6}; // {1, 3, 4}; //
        int[] c = {1000000000, 0}; // {1,2,3,21,4,5,6,6,7,8,9}; // {2, 6}; //
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = ListNode.constructLinkedList(a);
        listNodes[1] = ListNode.constructLinkedList(b);
        listNodes[2] = ListNode.constructLinkedList(c);
        ListNode head = func(listNodes);
        ListNode.printLinkedList(head);
    }
}
