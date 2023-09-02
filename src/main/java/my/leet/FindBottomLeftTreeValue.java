package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/** 513.树左下角的值 */
public class FindBottomLeftTreeValue {

    static int func(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode ans = root;
        TreeNode tag = new TreeNode(0, null, null);
        TreeNode node = null;
        TreeNode pre = null;
        queue.add(root);
        queue.add(tag);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node==tag && queue.size()>0) queue.add(tag);
            if (pre==tag) ans = node;
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
            pre = node;
        }
        return ans.val;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,null,5,6,null,null,7};  //{1,2,3,4,5,6};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int n = func(root);
        System.out.println(n);
    }
}
