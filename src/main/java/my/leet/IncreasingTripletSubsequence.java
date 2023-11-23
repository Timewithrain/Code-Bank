package my.leet;

/** 337. 递增的三元子序列 */
public class IncreasingTripletSubsequence {

    /** 出错 */
    static boolean func(int[] nums) {
        boolean ans = false;
        int l = nums.length;
        for (int i = 0; i < l-2; i++) {
            int cnt = 1, pre = nums[i];
            for (int j = i+1; j < l; j++) {
                if (pre < nums[j]) {
                    cnt++;
                    pre = nums[j];
                }
                if (cnt==3) return true;
            }
        }
        return ans;
    }

    /** 左最小数组+右最大数组 */
    static boolean func2(int[] nums) {
        boolean ans = false;
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        left[0] = nums[0];
        right[l-1] = nums[l-1];
        for (int i = 1; i < l; i++) {
            left[i] = Math.min(left[i-1], nums[i]);
            right[l-i-1] = Math.max(right[l-i], nums[l-i-1]);
        }
        for (int i = 1; i < l-1; i++) {
            if (left[i-1] < nums[i] && nums[i] < right[i+1]) {
                return true;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
