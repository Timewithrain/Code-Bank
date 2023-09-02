package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    static TreeNode dfs(int[] inorder, int ii, int ij, int[] postorder, int pi, int pj) {
        if (pi>pj || ii>ij) return null;
        TreeNode node = new TreeNode(postorder[pj]);
        int in_mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[pj] == inorder[i]) {
                in_mid = i;
                break;
            }
        }
        node.left = dfs(inorder, ii, in_mid-1, postorder, pi, pi+in_mid-ii-1);
        node.right = dfs(inorder, in_mid+1, ij, postorder, pi+in_mid-ii, pj-1);
        return node;
    }

    static TreeNode func(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = func(inorder, postorder);
        BinaryTree.printBinaryTree(root);
    }
}
