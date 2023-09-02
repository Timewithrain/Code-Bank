package my.leet;

import my.leet.utils.ArrayUtils;
import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindModeInBinarySearchTree {

    static void dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root==null) return;
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        dfs(root.left, map);
        dfs(root.right, map);
    }

    static int[] func(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (list.isEmpty()) list.add(entry.getKey());
            else if (entry.getValue() > map.get(list.get(0))) {
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == map.get(list.get(0))) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Integer[] nums = {2,null,3,null,4,null,5,null,6}; // {1,null,2,2,3,3};
        TreeNode root = BinaryTree.createBinaryTree(nums);
        int[] res = func(root);
        ArrayUtils.printArray(res);
    }
}
