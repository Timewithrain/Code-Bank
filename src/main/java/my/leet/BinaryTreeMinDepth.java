package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/** 111.二叉树最小深度 */
public class BinaryTreeMinDepth {

    static int dfs(TreeNode root, int depth) {
        if (root==null)
            return 0;
        if (root.left==null && root.right==null) {
            return depth;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left!=null) left = dfs(root.left, depth+1);
        if (root.right!=null) right = dfs(root.right, depth+1);
        return Math.min(left, right);
    }

    /** 统计最小深度需要避免返回值0的情况出现，需要在递归过程中累计层数 */
    static int func(TreeNode root) {
        return dfs(root, 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Integer[] iNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        TreeNode root = BinaryTree.createBinaryTree(new ArrayList<>(Arrays.asList(iNums)));
        System.out.println(func(root));

    }

}
