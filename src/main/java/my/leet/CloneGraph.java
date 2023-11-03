package my.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/** 133. 克隆图 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static void dfs(Node oldNode, Node newNode, HashMap<Node, Node> map, HashSet<Node> visited) {
        if (visited.contains(oldNode)) return;
        if (newNode.neighbors == null) {
            newNode.neighbors = new ArrayList<>();
            for (int i=0; i< oldNode.neighbors.size(); i++) {
                Node oldNei = oldNode.neighbors.get(i);
                if (!map.containsKey(oldNei)) {
                    Node n = new Node(oldNei.val);
                    n.neighbors = null;
                    map.put(oldNei, n);
                }
                Node newNei = map.get(oldNei);
                newNode.neighbors.add(newNei);
                dfs(oldNei, newNei, map, visited);
            }
            visited.add(oldNode);
        }
    }

    static Node func(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        Node newNode = node!=null ? new Node(node.val) : null;
        if (newNode!=null) {
            newNode.neighbors = new ArrayList<>();
            map.put(node, newNode);
            for (int i=0; i< node.neighbors.size(); i++) {
                Node oldNei = node.neighbors.get(i);
                if (!map.containsKey(oldNei)) {
                    Node n = new Node(oldNei.val);
                    n.neighbors = null;
                    map.put(oldNei, n);
                }
                Node newNei = map.get(oldNei);
                newNode.neighbors.add(newNei);
            }
            visited.add(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
                Node oldNei = node.neighbors.get(i);
                Node newNei = newNode.neighbors.get(i);
                dfs(oldNei, newNei, map, visited);
            }
        }
        return newNode;
    }

    public static void main(String[] args) {

    }
}
