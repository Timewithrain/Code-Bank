package my.exam.tencent;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/**
 * 牛牛的二叉树
 * 牛牛有一棵二叉树，二叉树的每个节点都是0或1
 * 请输出由根节点到叶子节点的全部路径中，权值为1的节点比权值为0的节点多1的路径的数量
 * 输入：
 * 0 1 1 0 1 1 0
 * 输出：
 * 2
 */
public class NiuNiuBinaryTree {

    static int dfs(TreeNode root, int zero, int one) {
        if (root.val==1) one++;
        else zero++;
        if (root.left==null && root.right==null) {
            return one-zero == 1 ? 1 : 0;
        }
        int ans = 0;
        if (root.left!=null)
            ans += dfs(root.left, zero, one);
        if (root.right!=null)
            ans += dfs(root.right, zero, one);
        return ans;
    }

    static int func(TreeNode root) {
        return dfs(root, 0, 0);
    }

    public static void main(String[] args) {
        Integer[] nums = {0,1,1,0,1,1,0}; // {1,0,0,1,0,null,1}; //
        TreeNode root = BinaryTree.createBinaryTree(nums);
        System.out.println(func(root));

    }
}
