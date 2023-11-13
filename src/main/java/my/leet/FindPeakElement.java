package my.leet;

/** 162. 寻找峰值 */
public class FindPeakElement {

    /***/
    static int func(int[] nums) {
        int ans = 0;
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid < nums.length && nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            if ((mid > 0 && mid < nums.length) && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    static int func2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>nums[ans]) ans = i;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
