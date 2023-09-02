package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 257.二叉树的所有路径 */
public class BinaryTreePaths {

    static void dfs(TreeNode root, List<Integer> tmp, List<String> ans) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left==null && root.right==null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                if (i==0)
                    sb.append(tmp.get(i));
                else {
                    sb.append("->");
                    sb.append(tmp.get(i));
                }
            }
            ans.add(sb.toString());
        } else {
            dfs(root.left, tmp, ans);
            dfs(root.right, tmp, ans);
        }
        tmp.remove(tmp.size()-1);
    }

    static List<String> func(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(root, tmp, ans);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8}; //{1,2,3,null,5};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        List<String> ans = func(root);
        System.out.println(ans);
    }
}
