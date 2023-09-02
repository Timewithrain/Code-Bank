package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 二叉树的深度优先遍历 */
public class BinaryTreeTraversal {

    /** 144.二叉树的前序遍历 */
    static void preorder(TreeNode root, List<Integer> ans) {
        if(root==null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    /** 94.二叉树的中序遍历 */
    static void inorder(TreeNode root, List<Integer> ans) {
        if(root==null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    /** 145.二叉树的后序遍历 */
    static void postorder(TreeNode root, List<Integer> ans) {
        if(root==null) return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }

    static List<Integer> func(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,null,2,3};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        List<Integer> ans = func(root);
        System.out.println(ans);
    }
}
