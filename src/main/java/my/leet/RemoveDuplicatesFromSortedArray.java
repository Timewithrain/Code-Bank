package my.leet;

/** 26. 删除有序数组的重复项 */
public class RemoveDuplicatesFromSortedArray {

    static int func(int[] nums) {
        int ans = 0;
        int l = nums.length;
        int[] tmp = new int[l];
        tmp[0] = nums[0];
        for (int i = 1; i < l; i++) {
            if (nums[i] > tmp[ans]) {
                tmp[++ans] = nums[i];
            }
        }
        for (int i = 0; i < ans+1; i++) {
            nums[i] = tmp[i];
        }
        return ans+1;
    }

    public static void main(String[] args) {

    }
}
