package my.leet;

import java.util.HashSet;

/** 1456. 定长子串中元音的最大数目 */
public class MaximumNumberOfVowelsInASubStringOfGivenLength {

    static int func(String s, int k) {
        int ans = 0;
        int l = s.length();
        int[] arr = new int[l+1];
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        for (int i = 1; i <= l; i++) {
            arr[i] = arr[i-1];
            if (set.contains(s.charAt(i-1))) {
                arr[i] += 1;
            }
            if (i >= k) {
                ans = Math.max(ans, arr[i] - arr[i-k]);
            }
        }
        return ans;
    }

    /** 不使用HashSet, 改为直接判断，优化后由13ms降低至8ms */
    static int func2(String s, int k) {
        int ans = 0;
        int l = s.length();
        int[] arr = new int[l+1];
        for (int i = 1; i <= l; i++) {
            arr[i] = arr[i-1];
            char c = s.charAt(i-1);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                arr[i] += 1;
            }
            if (i >= k) {
                ans = Math.max(ans, arr[i] - arr[i-k]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
