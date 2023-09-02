package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 617. 合并二叉树 */
public class MergeTwoBinaryTrees {

    static TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null) return null;
        if (root1!=null && root2!=null) {
            root1.val += root2.val;
            root1.left = dfs(root1.left, root2.left);
            root1.right = dfs(root1.right, root2.right);
        }
        else {
            if (root1==null) return root2;
            if (root2==null) return root1;
        }
        return root1;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1,3,2,5};
        Integer[] nums2 = {2,1,3,null,4,null,7};
        TreeNode root1 = BinaryTree.createBinaryTree(nums1);
        TreeNode root2 = BinaryTree.createBinaryTree(nums2);
        TreeNode root = dfs(root1, root2);
        BinaryTree.printBinaryTree(root);
    }
}
