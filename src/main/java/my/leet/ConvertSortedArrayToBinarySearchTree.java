package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 108. 将有序数组转化为二叉搜索树 */
public class ConvertSortedArrayToBinarySearchTree {

    static TreeNode convert(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convert(nums, start, mid-1);
        node.right = convert(nums, mid+1, end);
        return node;
    }

    static TreeNode func(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = func(nums);
        BinaryTree.printBinaryTree(root);
    }
}
