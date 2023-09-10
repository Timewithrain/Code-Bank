package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 337. 打家劫舍III */
public class HouseRobberIII {

    static int[] dfs(TreeNode root) {
        if (root==null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, notRob};
    }

    static int func(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,5,1,4,2}; // {3,2,3,null,3,null,1}; // {3,4,5,1,3,null,1}; // {1,2,3,0,2}; // {1}; // {6,1,3,2,4,7}; //
        TreeNode root = BinaryTree.createBinaryTree(nums);
        System.out.println(func(root));
    }
}
