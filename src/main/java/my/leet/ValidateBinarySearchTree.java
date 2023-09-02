package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 98.验证二叉搜索树 */
public class ValidateBinarySearchTree {

    /** 中序遍历解法 */
    static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root==null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }

    /** 纯递归解法 */
    static boolean isBST(TreeNode root, long min, long max) {
        if (root==null) return true;
        if (root.val<=min || root.val>=max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
    static boolean isValidBST2(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static void main(String[] args){
        Integer[] nums = {2147483647}; //{5,4,6,null,null,3,7}; // {2,1,3};  // {5,1,4,null,null,3,6};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        System.out.println(isValidBST2(root));
    }
}
