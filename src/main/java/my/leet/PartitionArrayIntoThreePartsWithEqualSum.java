package my.leet;

import my.leet.utils.ArrayUtils;

/** 1013. 将数组分成和相等的三个部分 */
public class PartitionArrayIntoThreePartsWithEqualSum {

    /** 深搜，找出所有离散分组，但不符合题意，题意要求三个分组连续 */
    static boolean dfs(int[] arr, int[] mask, int a, int b, int i, int opt, int part) {
        ArrayUtils.printArray(mask);
        if (a==part && b==part) return true;
        if (i==arr.length) return false;
        boolean ans = false;
        if (opt==1 && mask[i]==0) {
            a += arr[i];
            mask[i] = 1;
            ans = dfs(arr, mask, a, b, i+1, 1, part);
            ans = ans ||dfs(arr, mask, a, b, i+1, 0, part);
            mask[i] = 0;
            a -= arr[i];
        }
        if (opt==1 && mask[i]==0) {
            b += arr[i];
            mask[i] = 2;
            ans = ans || dfs(arr, mask, a, b, i+1, 1, part);
            ans = ans || dfs(arr, mask, a, b, i+1, 0, part);
            mask[i] = 0;
            b -= arr[i];
        }
        return ans;
    }

    static boolean func(int[] arr) {
        int l = arr.length;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) return false;
        int[] mask = new int[l];
        boolean ans = dfs(arr, mask, 0, 0, 0, 1, sum/3);
        ans = ans || dfs(arr, mask, 0, 0, 0, 0, sum/3);
        return ans;
    }

    /** 贪心法，分别从前往后和从后往前查找两个分组，剩余中间的部分即为第三个分组，三个分组连续，符合题意 */
    static boolean func2(int[] arr) {
        int l = arr.length;
        int sum = 0;
        boolean ans = false;
        for (int i = 0; i < l; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) return ans;
        int i = 0, j = l-1;
        int left = arr[i], right = arr[j];
        while (i < j-1) {
            if (left != sum/3) {
                i++;
                left += arr[i];
            } else {
                break;
            }
        }
        while (i < j-1) {
            if (right != sum/3) {
                j--;
                right += arr[j];
            } else {
                break;
            }
        }
        if (left==right && left==sum/3 && i<j-1) ans = true;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {24,-4,-5,-12,5,16,-12,22,2}; // {18,12,-18,18,-19,-1,10,10}; //{0,2,1,-6,6,7,9,-1,2,0,1}; // {3,3,6,5,-2,2,5,1,-9,4}; // {0,2,1,-6,6,7,9,-1,2,0,1}; // {0,2,1,-6,6,-7,9,1,2,0,1}; //
        System.out.println(func2(arr));

    }
}
