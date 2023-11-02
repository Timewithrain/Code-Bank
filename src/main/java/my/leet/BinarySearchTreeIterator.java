package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.LinkedList;

/** 173. 二叉搜索树迭代器 */
public class BinarySearchTreeIterator {

     static class BSTIterator {

        private LinkedList<TreeNode> stack = new LinkedList<>();

        private void pushStack(TreeNode root) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushStack(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right!=null) pushStack(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {7,3,15,null,null,9,20};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.printf("%d ", iterator.next());
        }
    }

}
