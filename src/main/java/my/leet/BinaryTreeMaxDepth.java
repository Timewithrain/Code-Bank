package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/** 104.二叉树的最大深度 */
public class BinaryTreeMaxDepth {

    static int dfs(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    static int func(TreeNode root) {
        int ans = dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int ans = func(root);
        System.out.println(ans);

        Integer[] numss = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(numss));
    }
}
