package my.leet;

/** 35. 搜索插入的位置 */
public class SearchInsertPosition {

    static int func(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low<=high) {
            int mid = (low + high) / 2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(func(nums, target));
    }
}
