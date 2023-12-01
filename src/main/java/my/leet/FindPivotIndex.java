package my.leet;

/** 724. 寻找数组的中心下标 */
public class FindPivotIndex {

    static int func(int[] nums) {
        int ans = -1;
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        for (int i = 0; i < l; i++) {
            if (i>0) left[i] = left[i-1] + nums[i-1];
            if (i>0) right[l-i-1] = right[l-i] + nums[l-i];
        }
        for (int i = 0; i < l; i++) {
            if (left[i] == right[i]) return i;
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
