package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

public class CountCompleteTreeNodes {

    /** 遍历法 时间复杂度O(n) */
    static int dfs(TreeNode root) {
        if (root==null)
            return 0;
        else
            return dfs(root.left) + dfs(root.right) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int n = dfs(root);
        System.out.println(n);
    }
}
