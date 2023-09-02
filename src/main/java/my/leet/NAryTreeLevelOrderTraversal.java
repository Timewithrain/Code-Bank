package my.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 429. N叉树的层次遍历 */
public class NAryTreeLevelOrderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    static List<List<Integer>> func(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node tag = new Node();
        if (root!=null) {
            queue.add(root);
            queue.add(tag);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node!=tag) {
                list.add(node.val);
                queue.addAll(node.children);
            } else {
                if (queue.size()>0) {
                    queue.add(tag);
                }
                ans.add(list);
                list = new ArrayList<>();
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
