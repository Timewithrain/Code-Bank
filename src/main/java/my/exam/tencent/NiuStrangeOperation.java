package my.exam.tencent;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 牛小妹的奇怪操作
 * 给定一个长度为n的数组，和一个值k，牛小妹可以对数组中的任何一个数做一个操作，操作定义如下：
 * 1. 将这个数的二进制表示中的最低位的1变成0
 * 请问经过k次操作后，数组中所有数的和最小是多少？
 */
public class NiuStrangeOperation {

    static int minusNumber(int n) { // 将整数n的最低位拆分出来
        int i = 1;
        while (n%2==0) {
            n = n >> 1;
            i = i << 1;
        }
        return i;
    }

    static int func(int[] nums, int k) {
        int l = nums.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            int num = nums[i];
            sum += num;
            ArrayList<Integer> t = new ArrayList<>();
            while (num!=0) {  // 将num以二进制由低到高的顺序拆分成若干个2的次幂
                int minus = minusNumber(num);
                t.add(-minus);
                num -= minus;
            }
            list.add(t);  // 将每个数的拆分结果存入list
        }
        int[] index = new int[l];  // 使用index数组记录每个list中的元素的访问位置
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 0; j < list.size(); j++) {
                if (index[j] == list.get(j).size()) continue;
                if (list.get(j).get(index[j]) < list.get(idx).get(index[idx])) {  // 找到最小元素的下标
                    idx = j;
                }
            }
            sum += list.get(idx).get(index[idx]);
            index[idx]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(func(nums, k));
    }
}
