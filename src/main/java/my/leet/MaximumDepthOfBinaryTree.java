package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree {

    static int func(TreeNode root) {
        if (root==null)
            return 0;
        else
            return Math.max(func(root.left), func(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int depth = func(root);
        System.out.println(depth);
    }
}
