package my.leet;

/** 1448. */
public class CountGoodNodesInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {this.val = val;}
    }

    static int retrieve(TreeNode root, int max) {
        if (root == null) return 0;
        int l = retrieve(root.left, Math.max(root.val, max));
        int r = retrieve(root.right, Math.max(root.val, max));
        int ans = l + r;
        if (root.val >= max) ans += 1;
        return ans;
    }

    static int func(TreeNode root) {
        return retrieve(root, Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        
    }
}