package my.leet;

/** 283. 移动零 */
public class MoveZeros {

    static void func(int[] nums) {
        int l = nums.length;
        int i = 0, j = 0;
        while (j < l) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < l) {
            nums[i++] = 0;
        }
    }

    public static void main(String[] args){

    }
}
