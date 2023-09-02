package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 404. 左子叶之和 */
public class SumOfLeftLeaves {

    static int func(TreeNode root) {
        if (root==null) return 0;
        if (root.left!=null && root.left.left==null && root.left.right==null)
            return func(root.right) + root.left.val;
        else
            return func(root.left) + func(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int ans = func(root);
        System.out.println(ans);
    }
}
