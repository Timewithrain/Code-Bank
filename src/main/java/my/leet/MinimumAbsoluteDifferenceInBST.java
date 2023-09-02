package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;

/** 530. 二叉树的最小绝对差 */
public class MinimumAbsoluteDifferenceInBST {

    /** 中序遍历+列表 */
    static void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root==null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    static int func(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            ans = Math.min(ans, Math.abs(list.get(i-1)-list.get(i)));
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,6,1,3};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int ans = func(root);
        System.out.println(ans);
    }
}
