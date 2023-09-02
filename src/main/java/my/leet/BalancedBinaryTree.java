package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;

/** 110.平衡二叉树 */
public class BalancedBinaryTree {

    /** dfs递归（获取深度）+列表（存储子树深度之差） */
    static int dfs(TreeNode root, ArrayList<Integer> list) {
        if (root==null) return 0;
        int left = dfs(root.left, list);
        int right = dfs(root.right, list);
        list.add(Math.abs(left-right));
        return Math.max(left, right) + 1;
    }

    static boolean func(TreeNode root) {
        boolean ans = true;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>1) {
                ans = false;
            }
        }
        return ans;
    }

    /** 标准解法: dfs递归，使用特殊值记录非平衡情况 */
    static int depth(TreeNode root) {
        if (root==null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left==-1 || right==-1) return -1;  // 子树中出现非平衡二叉树
        if (Math.abs(left-right)<=1) return Math.max(left, right)+1;  // 子树深度差值不超过1，返回最大深度
        else return -1;  // 子树差值超过1，返回-1
    }

    static boolean func2(TreeNode root) {
        int dep = depth(root);
        return dep!=-1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,3,null,null,4,4};  // {3,9,20,null,null,15,7};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        boolean ans = func(root);
        System.out.println(ans);
    }
}
