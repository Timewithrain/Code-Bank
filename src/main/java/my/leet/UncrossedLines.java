package my.leet;

/** 1035. 不相交的线 */
public class UncrossedLines {

    static int func(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, Math.max(dp[i-1][j], dp[i][j-1]));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,7,1,7,5}; // {2,5,1,2,5}; // {1,4,2}; //
        int[] nums2 = {1,9,2,5,1}; // {10,5,2,1,5,2}; // {1,2,4}; //
        System.out.println(func(nums1, nums2));
    }
}
