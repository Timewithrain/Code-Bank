package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/**
 * 101. 对称二叉树
 */
public class SameTree {

    static boolean func(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        else if (p!=null && q!=null && p.val==q.val)
            return func(p.left, q.left) && func(p.right, q.right);
        else
            return false;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,3,4,5,6};
        TreeNode p = BinaryTree.createBinaryTree(nums1);
        TreeNode q = BinaryTree.createBinaryTree(nums2);
        System.out.println(func(p, q));
    }

}
