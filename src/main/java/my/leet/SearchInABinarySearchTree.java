package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 700. 二叉搜索树中的搜索 */
public class SearchInABinarySearchTree {

    static TreeNode func(TreeNode root, int val) {
        if (root==null) return null;
        if (root.val==val) return root;
        else if (root.val>val) return func(root.left, val);
        else return func(root.right, val);
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        int val = 2;
        TreeNode root = BinaryTree.createBinaryTree(nums);
        TreeNode node = func(root, val);
        BinaryTree.printBinaryTree(node);
    }
}
