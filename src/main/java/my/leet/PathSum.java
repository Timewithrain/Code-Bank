package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

public class PathSum {

    static boolean getSum(TreeNode root, int currentSum, int targetSum) {
        if (root==null) return false;
        if ((currentSum+root.val) == targetSum && root.left==null && root.right==null)
            return true;
        else {
            boolean l = getSum(root.left, currentSum+root.val, targetSum);
            boolean r = getSum(root.right, currentSum+root.val, targetSum);
            return l || r;
        }
    }

    static boolean func(TreeNode root, int targetSum) {
        return getSum(root, 0, targetSum);
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};  // {1,2,3};
        int targetSum = 22;  // 5;
        TreeNode root = BinaryTree.createBinaryTree(nums);
        System.out.println(func(root, targetSum));
    }
}
