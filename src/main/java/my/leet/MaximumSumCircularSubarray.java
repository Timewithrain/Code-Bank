package my.leet;

public class MaximumSumCircularSubarray {

    /** O(n^2) 超时 */
    static int func(int[] nums) {
        int l = nums.length;
        int[] ansArr = new int[l];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            int[] arr = new int[l];
            arr[0] = nums[i];
            ansArr[i] = arr[0];
            for (int j = 1; j < l; j++) {
                int idx = (i + j) % l;
                if (arr[j-1] + nums[idx] > 0) {
                    arr[j] = Math.max(arr[j-1] + nums[idx], nums[idx]);
                } else {
                    arr[j] = nums[idx];
                }
                ansArr[i] = Math.max(ansArr[i], arr[j]);
            }
            ans = Math.max(ans, ansArr[i]);
        }
        return ans;
    }

    /** 分情况讨论 O(n) */
    static int func2(int[] nums) {
        int l = nums.length;
        int[] arr = new int[l];
        arr[0] = nums[0];
        int ans = nums[0];
        int[] pre = new int[l];
        int[] post = new int[l];
        int[] preMax = new int[l];
        int[] postMax = new int[l];
        pre[0] = nums[0];
        preMax[0] = nums[0];
        post[l-1] = nums[l-1];
        postMax[l-1] = nums[l-1];
        for (int i = 1; i < l; i++) {  // 最大结果子数组存在于数组内部
            if (arr[(i-1)] + nums[i] > 0) {
                arr[i] = Math.max(arr[i-1] + nums[i], nums[i]);
            } else {
                arr[i] = nums[i];
            }
            ans = Math.max(ans, arr[i%l]);
            pre[i] = pre[i-1] + nums[i];  // 构造首位最大值数组
            preMax[i] = Math.max(preMax[i-1], pre[i]);
            post[l-1-i] = post[l-i] + nums[l-1-i];
            postMax[l-1-i] = Math.max(postMax[l-i], post[l-1-i]);
        }
        for (int i = 1; i < l; i++) {
            ans = Math.max(ans, preMax[i-1]+postMax[i]);
        }
        return  ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2}; // {5,6,1,4,8,-8,7,-5,3}; // {3, -2, 2, -3}; // {5, -3, 5}; //
        int ans = func(nums);
        System.out.println(ans);
        ans = func2(nums);
        System.out.println(ans);
    }
}
