package my.leet;

import java.util.HashMap;

/** 138. 随机链表的复制 */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Node func(Node head) {
        Node newHead = new Node(0);
        Node p = head;
        Node q = newHead;
        int index = 1;
        HashMap<Node, Integer> oldMap = new HashMap<>();
        HashMap<Integer, Node> newMap = new HashMap<>();
        while (p!=null) {
            q.next = new Node(p.val);
            oldMap.put(p, index);
            q = q.next;
            newMap.put(index, q);
            p = p.next;
            index++;
        }
        p = head;
        q = newHead.next;
        while (p!=null) {
            int i = oldMap.getOrDefault(p.random, -1);
            q.random = i!=-1 ? newMap.get(i) : null;
            p = p.next;
            q = q.next;
        }
        return newHead.next;
    }

    public static void main(String[] args){

    }
}
