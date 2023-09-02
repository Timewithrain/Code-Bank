package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 226. 反转二叉树 */
public class InvertBinaryTree {

    static TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode right = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = right;
        return root;
    }

    public static void main(String[] args){
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        TreeNode newRoot = invertTree(root);
        BinaryTree.printBinaryTree(newRoot);
    }
}
