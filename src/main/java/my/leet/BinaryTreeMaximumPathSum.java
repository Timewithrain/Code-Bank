package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 124. 二叉树中的最大路径和 */
public class BinaryTreeMaximumPathSum {

    static int[] maxSum(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE/2, Integer.MIN_VALUE/2};
        if (root==null) return ans;
        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);
        // ans[0]保存以当前节点为根的子树中最大的路径和，不参与祖先节点路径拼接
        ans[0] = Math.max(left[1], 0) + root.val + Math.max(right[1], 0); // 包含当前节点的最大路径和
        ans[0] = Math.max(ans[0], Math.max(left[0], right[0]));  // 不包含当前节点的最大路径和
        // ans[1]保存左右子树中的单链最大路径和，参与祖先节点的路径拼接
        ans[1] = root.val + Math.max(Math.max(left[1], right[1]), 0);
        return ans;
    }

    static int func(TreeNode root) {
        int[] ans = maxSum(root);
        return Math.max(ans[0], ans[1]);
    }

    public static void main(String[] args) {
        Integer[] nums = {-1,8,2,null,-9,0,null,null,null,-3,null,null,-9,null,2}; // {0,1,1}; //{-10,9,20,null,null,15,7}; // {-3}; //  {1,2,3}; //
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int ans = func(root);
        System.out.println(ans);
    }
}
