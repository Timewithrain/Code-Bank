package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;

/** 1382. 将二叉搜索树变平衡 */
public class BalanceABinarySearchTree {

    static void inOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root==null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    static TreeNode construct(ArrayList<TreeNode> list, int i, int j) {
        if (i>j) return null;
        int mid = (i+j)/2;
        TreeNode node = list.get(mid);
        node.left = construct(list, i, mid-1);
        node.right = construct(list, mid+1, j);
        return node;
    }

    static TreeNode func(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        root = construct(list, 0, list.size()-1);
        return root;
    }


    public static void main(String[] args){
        Integer[] nums = {4,2,7,1,3};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        root = func(root);
        BinaryTree.printBinaryTree(root);
    }
}
