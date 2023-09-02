package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 236. 二叉树的最近公共祖先 */
public class LowestCommonAncestorOfABinaryTree {

    static boolean dfs(TreeNode root, TreeNode target, List<TreeNode> ancestors) {
        if  (root==null) return false;
        boolean ans = false;
        ancestors.add(root);
        if (root==target) return true;
        ans = dfs(root.left, target, ancestors);
        if (ans) return true;
        ans = dfs(root.right, target, ancestors);
        if (ans) return true;
        ancestors.remove(ancestors.size()-1);
        return false;
    }

    static TreeNode func(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        dfs(root, p, listP);
        dfs(root, q, listQ);
        TreeNode ans = root;
        for (int i = 0; i < listP.size() && i < listQ.size() ; i++) {
            if (listP.get(i) == listQ.get(i)) {
                ans = listP.get(i);
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        BinaryTree tree = new BinaryTree(nums);
        TreeNode root = tree.root;
        TreeNode p = tree.list.get(1);  // 5
        TreeNode q = tree.list.get(10);  // 4
        TreeNode ans = func(root, p, q);
        System.out.println(ans.val);
     }
}
