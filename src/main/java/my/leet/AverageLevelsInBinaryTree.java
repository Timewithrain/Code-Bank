package my.leet;

import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsInBinaryTree {

    static List<Double> func(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tag = new TreeNode();
        if (root!=null) {
            queue.add(root);
            queue.add(tag);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node!=tag) {
                list.add((long)node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            } else {
                if (queue.size()>0) {
                    queue.add(tag);
                }
                long sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += list.get(i);
                }
                ans.add(sum/(double)list.size());
                list = new ArrayList<>();
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
