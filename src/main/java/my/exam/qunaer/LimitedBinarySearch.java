package my.exam.qunaer;

/**
 * 2. 受限的二分搜索
 * 给定一个长度为n的有序有重复数组a和一个值v，使用二分查找发找出其中第一个等于v的元素出现的位置
 * 若不存在该数则输出数组长度+1
 * 输入：
 * 5 4
 * 1 2 4 4 5
 * 输出：
 * 3
 */
public class LimitedBinarySearch {

    static public int find (int n, int v, int[] a) {
        int l = a.length;
        int low = 0;
        int high = l-1;
        while (low<=high) {
            int mid = (low + high) / 2;
            if (a[mid] == v) {
                while(mid > 0 && a[mid] == a[mid-1]) mid--;
                return mid+1;
            } else if (a[mid] < v) {
                low = mid + 1;
                while(low < l-1 && a[low] == a[low+1]) low++;
            } else {
                high = mid - 1;
                while(high > 0 && a[high] == a[high-1]) high--;
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        int n = 5;
        int v = 2;
        int[] a = {1,2,2,2,2};
        int ans = find(n, v, a);
        System.out.println(ans);
    }
}
