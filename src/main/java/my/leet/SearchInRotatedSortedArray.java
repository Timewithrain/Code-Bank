package my.leet;

/** 33.搜索旋转排序数组 **/
public class SearchInRotatedSortedArray {

    /** 原始二分查找 */
    static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (high==-1) return -1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (nums[mid] < target) {
                low = mid+1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /** 旋转数组二分查找 根据target和mid是否在同一分段判断low和high的移动方向*/
    static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (high==-1) return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid] >= nums[0] == target >= nums[0]) {  // mid和target在同一分段
                if (nums[mid]>target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {  // 在不同分段
                if (target>=nums[0]) {  // target在前段，mid在后段
                    high = mid - 1;
                } else {  // target在后段，mid在前段
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
