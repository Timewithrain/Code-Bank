package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 701. 二叉搜索树的插入 */
public class InsertIntoABinarySearchTree {

    static TreeNode func(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);
        if (root.val > val) root.left = func(root.left, val);
        if (root.val < val) root.right = func(root.right, val);
        return root;
    }

    public static void main(String[] args){
        Integer[] nums = {4,2,7,1,3};
        int val = 5;
        TreeNode root = BinaryTree.createBinaryTree(nums);
        root = func(root, val);
        BinaryTree.printBinaryTree(root);
    }
}
