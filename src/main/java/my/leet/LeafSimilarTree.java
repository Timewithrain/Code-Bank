package my.leet;

import my.leet.utils.TreeNode;

import java.util.ArrayList;

/** 872. 叶子相似的树 */
public class LeafSimilarTree {

    static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        if (root.left == null && root.right == null) list.add(root.val);
        inorder(root.right, list);
    }

    static boolean func(TreeNode root1, TreeNode root2) {
        boolean flag = true;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) flag = false;
        }
        return flag;
    }

    public static void main(String[] args){

    }
}
