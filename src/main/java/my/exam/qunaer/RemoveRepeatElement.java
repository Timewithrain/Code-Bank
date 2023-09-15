package my.exam.qunaer;

import my.leet.utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1. 移除重复元素
 * 给定一个长度为n的数组，删除其中的重复元素，仅保留最后一个重复元素
 * 输入描述：一个n，代表数组长度，下一行n个数，代表数组元素
 * 输入:
 * 8
 * 10 20 20 99 20 99 100 100
 * 输出：
 * 10 20 99 100
 */
public class RemoveRepeatElement {

    static int[] func(int n, int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (list.contains(nums[i])) {
                list.remove(new Integer(nums[i]));
            }
            list.add(nums[i]);
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer in : list) {
            ans[i++] = in;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] map = new int[501];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] ans = func(n, nums);
        ArrayUtils.printArray(ans);

    }
}
