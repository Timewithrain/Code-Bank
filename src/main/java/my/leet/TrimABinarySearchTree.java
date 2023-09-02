package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 669. 修剪二叉树 */
public class TrimABinarySearchTree {

    static TreeNode func(TreeNode root, int low, int high) {
        if (root==null) return null;
        if (low<=root.val && root.val<=high) {
            root.left = func(root.left, low, high);
            root.right = func(root.right, low, high);
        } else if (root.val < low) {
            return func(root.right, low, high);
        } else {
            return func(root.left, low, high);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {3,0,4,null,2,null,null,1};  //{1,0,2};
        int low = 1;
        int high = 3;
        TreeNode root = BinaryTree.createBinaryTree(nums);
        root = func(root, low, high);
        BinaryTree.printBinaryTree(root);
    }
}
