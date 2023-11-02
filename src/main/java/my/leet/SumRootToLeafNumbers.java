package my.leet;

import my.leet.utils.TreeNode;

/** 129. 求根节点到叶节点数字之和 */
public class SumRootToLeafNumbers {

    static int inorder(TreeNode root, int cur, int ans) {
        if (root==null) return ans;
        cur = cur * 10 + root.val;
        if (root.left==null && root.right==null) ans += cur;
        if (root.left!=null) ans = inorder(root.left, cur, ans);
        if (root.right!=null) ans = inorder(root.right, cur, ans);
        return ans;
    }

    static int func(TreeNode root) {
        return inorder(root, 0, 0);
    }

    public static void main(String[] args) {

    }
}
