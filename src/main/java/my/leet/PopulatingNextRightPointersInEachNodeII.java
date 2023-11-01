package my.leet;

import java.util.LinkedList;
import java.util.Queue;

/** 117. 填充每一个节点的下一个右侧节点指针II */
public class PopulatingNextRightPointersInEachNodeII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    static Node func(Node root) {
        if (root==null) return null;
        Node tag = new Node(-1);
        Queue<Node> queue = new LinkedList<>();
        Node last = null;
        queue.add(root);
        queue.add(tag);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node==tag) {
                if (!queue.isEmpty()) queue.add(tag);
                if (last!=null) {
                    last.next = null;
                    last = null;
                }
            } else {
                if (last!=null) {
                    last.next = node;
                }
                last = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
