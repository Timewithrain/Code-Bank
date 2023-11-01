package my.leet;

import my.leet.utils.TreeNode;

import java.util.ArrayList;

/** 114. 二叉树展开为链表 */
public class FlattenBinaryTreeToLinkedList {

    static void preorder(TreeNode root, ArrayList<TreeNode> list) {
        if (root==null) return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    static void func(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        TreeNode last = list.size()>0 ? list.get(0) : null;
        if (last!=null) last.left = null;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = null;
            last.right = node;
            last = node;
        }
    }

    public static void main(String[] args){

    }
}
