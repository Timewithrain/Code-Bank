package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 538. 把二叉树搜索树转换为累加树 */
public class ConvertBSTToGreaterTree {

    static int dfs(TreeNode root, int n) {
        if (root==null) return n;
        int right = dfs(root.right, n);
        root.val += right;
        int left = dfs(root.left, root.val);
        return left;
    }

    static TreeNode func(TreeNode root) {
        if (root==null) return null;
        dfs(root, 0);
        return root;
    }

    public static void main(String[] args){
        Integer[] nums = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        root = func(root);
        BinaryTree.printBinaryTree(root);
    }
}
