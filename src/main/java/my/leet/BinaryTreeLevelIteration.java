package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelIteration {

    static List<List<Integer>> func(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        TreeNode tag = new TreeNode();
        queue.add(root);
        queue.add(tag);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node!=null && node != tag) {
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                tmp.add(node.val);
            } else {
                if (tmp.size()>0) {
                    ans.add(tmp);
                    tmp = new ArrayList<>();
                    queue.add(tag);
                }
            }
        }
        return ans;
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tag = new TreeNode();
        if (root!=null) {
            queue.add(root);
            queue.add(tag);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node!=tag) {
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            } else {
                if (queue.size()>0) {
                    queue.add(tag);
                }
                ans.add(list);
                list = new ArrayList<>();
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if (i >= ans.size()/2) break;
            List<Integer> t = ans.get(ans.size()-i-1);
            ans.set(ans.size()-i-1, ans.get(i));
            ans.set(i, t);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }
}
