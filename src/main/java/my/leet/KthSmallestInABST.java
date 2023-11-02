package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 250. 二叉搜索树中第K小的元素 */
public class KthSmallestInABST {

    static int[] inorder(TreeNode root, int k, int[] ans) {
        if (root==null) return ans;
        if (ans[1]<k) ans = inorder(root.left, k, ans);
        ans[1] += 1;
        if (ans[1] == k) {
            ans[0] = root.val;
        }
        if (ans[1]<k) ans = inorder(root.right, k, ans);
        return ans;
    }

    static int func(TreeNode root, int k) {
        int[] ans = new int[2];
        ans = inorder(root, k, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        Integer[] nums = {5,3,6,2,4,null,null,1}; // {3,1,4,null,2}; //
        int k = 3;
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int ans = func(root, k);
        System.out.println(ans);
    }
}
