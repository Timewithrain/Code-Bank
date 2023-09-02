package my.leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 338. 比特位计数
 */
public class BitCounter {

    /** 使用内置函数实现 */
    static int[] func0(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    /** 动态规划实现
     *  case1: 若x为2的幂，则x&(x-1)为0，ans[x]赋值为1
     *  case2: 若x不为2的幂，则存在小于x的最大的2的幂j，x中的1由最高位(j)的1和剩余所有的1组成，ans[x-j]即记录了除最高位外所有的1的个数
     *  例：x=7(111)，则j=4(100)，x-j=3(011)
     *     ans[7] = ans[7-4] + 1 = 2 + 1 = 3
     */
    static int[] func1(int n) {
        int[] ans = new int[n+1];
        if (n==0) return ans;
        ans[1] = 1;
        if (n==1) return ans;
        ans[2] = 1;
        if (n==2) return ans;
        int highBit = 2;
        for (int i = 3; i <= n; i++) {
            if ((i&(i-1)) == 0) {
                highBit = i;
                ans[i] = 1;
                continue;
            }
            ans[i] = ans[i-highBit] + 1;  // ans[i-highBit]获取除最高位外剩余位数的1的个数
        }
        return ans;
    }

    /** 由已有的位数生成新的数，时间复杂度n(log(n)) */
    static int[] func2(int n) {
        int[] ans = new int[n+1];
        if (n==0) return ans;
        ans[1] = 1;
        if (n==1) return ans;
        ans[2] = 1;
        if (n==2) return ans;
        for (int i = 1; i <= n; i++) {  // n
            int mask = 1;
            if ((i&(i-1)) == 0) {
                ans[i] = 1;
                continue;
            }
            while (mask<i) {  // log n
                ans[i] += ans[mask&i];
                mask *= 2;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int n = 7;
        int[] ans = func1(n);
        List<Integer> ansList = Arrays.stream(ans).boxed().collect(Collectors.toList());
        System.out.println(ansList);
    }
}
