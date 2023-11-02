package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 103. 二叉树的锯齿形层序遍历 */
public class BinaryTreeZigzagLevelOrderTraversal {

    static List<List<Integer>> func(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> tmp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode tag = new TreeNode();
        if (root!=null) {
            queue.add(root);
            queue.add(tag);
        }
        while (!queue.isEmpty()) {  // 层序遍历记录节点
            TreeNode node = queue.poll();
            if (node == tag) {
                if (!queue.isEmpty()) queue.add(node);
            } else {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            tmp.add(node);
        }
        int cnt = 0;
        ArrayList<Integer> t = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            TreeNode node = tmp.get(i);
            if (node==tag) {
                if (cnt%2 != 0) {  // 以tag分层，奇数层逆序
                    Collections.reverse(t);
                }
                ans.add(t);
                t = new ArrayList<>();
                cnt++;
                continue;
            }
            t.add(node.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {}; // {1}; // {3,9,20,null,null,15,7}; //
        TreeNode root = BinaryTree.createBinaryTree(nums);
        List<List<Integer>> ans = func(root);
        System.out.println(ans);
    }
}
