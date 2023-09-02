package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 654. 最大二叉树 */
public class MaximumBinaryTree {

    static TreeNode dfs(int[] nums, int i, int j) {
        if (i>j) return null;
        int max_idx = i;
        for (int k = i+1; k <= j; k++) {
            if (nums[k] > nums[max_idx]) max_idx = k;
        }
        TreeNode node = new TreeNode(nums[max_idx]);
        node.left = dfs(nums, i, max_idx-1);
        node.right = dfs(nums, max_idx+1, j);
        return node;
    }

    static TreeNode func(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = func(nums);
        BinaryTree.printBinaryTree(root);
    }
}
