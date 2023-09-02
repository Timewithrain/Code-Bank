package my.leet.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public TreeNode root;

    public ArrayList<TreeNode> list = new ArrayList<>();

    public BinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            if (i==0) root = node;
            this.list.add(node);
        }
        int p = 1;  // 标记已分配的子节点
        for (int i = 0; i < this.list.size(); i++) {
            TreeNode node = this.list.get(i);
            if (node==null) continue;
            if (p < this.list.size()) node.left = this.list.get(p++);
            if (p < this.list.size()) node.right = this.list.get(p++);
        }
    }

    // {1,2,3,4,null,5,6,null,null,7}
    public BinaryTree(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = nums[i]!=null ? new TreeNode(nums[i]) : null;
            if (i==0) root = node;
            this.list.add(node);
//            if (i>0 && this.list.get((i-1)/2)!=null) {  // 完全二叉树可如此构造，普通二叉树出错
//                if (i%2 == 0) this.list.get((i-1)/2).right = node;
//                if (i%2 == 1) this.list.get((i-1)/2).left = node;
//            }
        }
        int p = 1;  // 标记已分配的子节点
        for (int i = 0; i < this.list.size(); i++) {
            TreeNode node = this.list.get(i);
            if (node==null) continue;
            if (p < this.list.size()) node.left = this.list.get(p++);
            if (p < this.list.size()) node.right = this.list.get(p++);
        }
    }

    public BinaryTree(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            TreeNode node = nums.get(i)!=null ? new TreeNode(nums.get(i)) : null;
            if (i==0) root = node;
            this.list.add(node);
        }
        int p = 1;  // 标记已分配的子节点
        for (int i = 0; i < this.list.size(); i++) {
            TreeNode node = this.list.get(i);
            if (node==null) continue;
            if (p < this.list.size()) node.left = this.list.get(p++);
            if (p < this.list.size()) node.right = this.list.get(p++);
        }
    }

    public static TreeNode createBinaryTree(int[] nums) {
        BinaryTree tree = new BinaryTree(nums);
        return tree.root;
    }

    public static TreeNode createBinaryTree(Integer[] nums) {
        BinaryTree tree = new BinaryTree(nums);
        return tree.root;
    }

    public static TreeNode createBinaryTree(List<Integer> nums) {
        BinaryTree tree = new BinaryTree(nums);
        return tree.root;
    }

    public static void printBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.printf("%d ", node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        BinaryTree tree = new BinaryTree(a);
        BinaryTree.printBinaryTree(tree.root);
    }

}

