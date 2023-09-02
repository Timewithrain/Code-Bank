package my.leet;

/** 153. 寻找旋转数组中的最小值 */
public class FindMinimumInRotatedSortedArray {

    static int func(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] <= nums[high]) return nums[low];
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= nums[0]) {  // mid位于第一段，检测区间右移
                low = mid + 1;
            } else if (nums[mid] > nums[mid-1]) {  // mid位于第二段，且mid不为最小值，检测区间左移
                high = mid - 1;
            } else {
                ans = nums[mid];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1}; // {3,4,5,1,2}; // {11,13,15,17}; // {4,5,6,7,0,1,2};  //
        System.out.println(func(nums));
    }
}
