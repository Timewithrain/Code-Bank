package my.leet;

/** 81. 搜索旋转排序数组II */
public class SearchInRotatedSortedArrayII {

    static boolean func(int[] nums, int target) {
        boolean ans = false;
        int low = 0;
        int high = nums.length - 1;
        while (nums[high]==nums[0] && high!=0) high--;  // 去除第二段中和第一段相同的元素，保证mid和target的分段检测结果正确
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target>=nums[0] == nums[mid]>=nums[0]) {  // target和mid在同一段，直接二分查找
                if (nums[mid] == target) {
                    ans = true;
                    break;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {  // target和mid不在同一段，调整low和high使mid和target为同一段
                if (nums[mid] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,6,7,0,1,2,4,4};  // {2,5,6,0,0,1,2};
        int target = 5;
        System.out.println(func(nums, target));
    }
}
