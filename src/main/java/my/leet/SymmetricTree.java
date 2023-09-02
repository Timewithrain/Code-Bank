package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/**
 * 101. 对称二叉树
 */
public class SymmetricTree {

    static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        else if (p!=null & q!=null && p.val==q.val)
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        else
            return false;
    }

    static boolean func(TreeNode root) {
        if (root==null)
            return true;
        else
            return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,3};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        System.out.println(func(root));
    }
}
