package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 235. 二叉搜索树的最近公共祖先 */
public class LowestCommonAncestorOfABinarySearchTree {

    /** 由于二叉搜索树的有序特性，两节点的最近公共祖先节点值必为两个子节点值之间，因此从根遍历到的首个节点必为最近公共祖先节点 */
    static TreeNode func(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root.val>p.val && root.val>q.val)
            return func(root.left, p, q);
        else if (root.val<p.val && root.val<q.val)
            return func(root.right, p, q);
        else
            return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode ans = func(root, p, q);
        System.out.println(ans.val);
    }
}
