package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 199. 二叉树的右视图 */
public class BinaryTreeRightSideView {

    static List<Integer> func(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tag = new TreeNode();
        TreeNode pre = tag;
        if (root!=null) {
            queue.add(root);
            queue.add(tag);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != tag) {
                if (pre==tag) ans.add(node.val);
                if (node.right!=null) queue.add(node.right);
                if (node.left!=null) queue.add(node.left);
            } else {
                if (queue.size()>0)
                    queue.add(tag);
            }
            pre = node;
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,null,5,null,4};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        List<Integer> ans = func(root);
        System.out.println(ans);
    }
}
