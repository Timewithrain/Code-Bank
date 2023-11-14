package my.leet;

/** 162. 寻找峰值 */
public class FindPeakElement {

    /** 二分法 */
    static int func(int[] nums) {
        int ans = 0;
        if (nums.length==1) return 0;
        if (nums.length==2) return nums[0]>nums[1] ? 0 : 1;
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid < nums.length-1 && nums[mid] < nums[mid+1]) {  // 比较mid及其左右的增减性确定左右界
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            if ((mid+1 >= nums.length || nums[mid] > nums[mid+1]) && (mid-1 < 0 || nums[mid] > nums[mid-1])) {  // 处理边界问题
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
        int[] nums = {1,2,3};
        int ans = func(nums);
        System.out.println(ans);
    }
}
