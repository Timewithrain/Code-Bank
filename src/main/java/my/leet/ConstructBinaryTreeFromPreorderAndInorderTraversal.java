package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    static TreeNode dfs(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij) {
        if (pi>pj || ii>ij) return null;
        TreeNode node = new TreeNode(preorder[pi]);
        int in_mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[pi] == inorder[i]) {
                in_mid = i;
                break;
            }
        }
        node.left = dfs(preorder, pi+1, pi+in_mid-ii, inorder, ii, in_mid-1);
        node.right = dfs(preorder, pi+in_mid-ii+1, pj, inorder, in_mid+1, ij);
        return node;
    }

    static TreeNode func(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = func(preorder, inorder);
        BinaryTree.printBinaryTree(root);
    }
}
