package my.leet;

/** 34.在排序数组中查找元素的第一个和最后一个位置 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    static int[] func(int[] nums, int target) {
        int[] ans = {-1, -1};
        int l = nums.length;
        if (l==0) return ans;
        int low = 0;
        int high = l - 1;
        while (low<=high) {  // 查找下界
            int mid = (low+high)/2;
            if (nums[mid]==target) {
                int i = mid;
                while (i>=0 && nums[i]==target) {
                    i--;
                }
                ans[0] = i+1;
                i = mid;
                while (i<l && nums[i]==target) {
                    i++;
                }
                ans[1] = i-1;
                return ans;
            } else if (nums[mid]<target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int[] func1(int[] nums, int target) {
        int[] ans = {-1, -1};
        int low = 0;
        int high = nums.length - 1;
        if (high==-1) return ans;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid]==target) {  // 找到结果
                int upLimit = mid;  // 查找下界
                while (low <= upLimit) {
                    int m = (low + upLimit) / 2;
                    if (nums[m]==target) {
                        upLimit = m - 1;
                    } else {
                        low = m + 1;
                    }
                }
                ans[0] = low;  // low是第一个大于等于target的下标
                int downLimit = mid;  // 查找上界
                while (downLimit<=high) {
                    int m = (downLimit + high) / 2;
                    if (nums[m] == target) {
                        downLimit = m + 1;
                    } else {
                        high = m - 1;
                    }
                }
                ans[1] = high;  // high是最后一个小于等于target的下标
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,3,4};
        int target = 3;
        int[] ans = func1(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
