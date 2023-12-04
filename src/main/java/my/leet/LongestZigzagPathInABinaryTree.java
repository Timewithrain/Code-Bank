package my.leet;

/** 1372. */
public class LongestZigzagPathInABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {this.val = val;}
    }

    static int retrieve(TreeNode root, int d, int cur) {
        if (root == null) return cur;
        int l = retrieve(root.left, 0, d==1 ? cur+1 : 1);
        int r = retrieve(root.right, 1, d==0 ? cur+1 : 1);
        return Math.max(l, r);
    }

    static int func (TreeNode root) {
        if (root == null) return 0;
        int l = retrieve(root.left, 0, 1);
        int r = retrieve(root.right, 1, 1);
        return Math.max(l, r) - 1;
    }

    public static void main(String[] args) {
        
    }
}