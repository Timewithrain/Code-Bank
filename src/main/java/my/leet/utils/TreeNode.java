package my.leet.utils;

public class TreeNode {
    public Integer val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {}

    public TreeNode(Integer value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
