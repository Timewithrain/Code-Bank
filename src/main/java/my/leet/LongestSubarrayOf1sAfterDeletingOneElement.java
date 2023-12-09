package my.leet;

/** 1493. 删除一个元素以后全为1的最长子数组 */
public class LongestSubarrayOf1sAfterDeletingOneElement {

    static int func(int[] nums) {
        int ans = 0;
        int l = nums.length, a = 0, b = 0;
        int zero = 0;
        while (a<l) {
            if (b<l && (zero < 1 || nums[b] != 0)) {
                if (nums[b] == 0) zero++;
                b++;
            } else {
                if (nums[a] == 0) zero--;
                a++;
            }
            ans = Math.max(ans, b-a);
        }
        return ans-1;
    }

    public static void main(String[] args) {


    }
}
