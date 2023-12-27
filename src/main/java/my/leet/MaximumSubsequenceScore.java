package my.leet;

import java.util.*;

/** 2542. 最大子序列的分数 */
public class MaximumSubsequenceScore {

    /** 出错 */
    static long func(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        int l = nums2.length;
        ArrayList<int[]> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < l; i++) {
            list.add(new int[]{nums2[i], i});
        }
        list.sort((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k-1; i++) {
            int n1 = nums1[list.get(i)[1]];
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        for (int i = k-1; i < list.size(); i++) {
            int n1 = nums1[list.get(i)[1]], cnt = k-1;
            Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
            while (cnt>0 && itr.hasNext()) {
                Map.Entry<Integer, Integer> entry = itr.next();
                n1 += entry.getKey() * entry.getValue();
                cnt -= entry.getValue();
            }
            ans = Math.max(ans, (long) n1 * list.get(i)[0]);
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        return ans;
    }

    /** 小根堆实现 */
    static long func2(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        int l = nums2.length;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            list.add(new int[]{nums2[i], nums1[i]});
        }
        list.sort((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int n1 = list.get(i)[1];
            int n2 = list.get(i)[0];
            while (queue.size() > k-1) {
                sum -= queue.poll();
            }
            queue.add(n1);
            sum += n1;
            if (queue.size() == k) {
                ans = Math.max(ans, (long) sum * n2);
            }
        }
        return ans;
    }

    /** 超时 */
    static long func3(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        int l = nums2.length;
        ArrayList<int[]> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < l; i++) {
            list.add(new int[]{nums2[i], nums1[i]});
        }
        list.sort((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k-1; i++) {
            int n1 = list.get(i)[1];
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        for (int i = k-1; i < list.size(); i++) {
            int n1 = list.get(i)[1], cnt = k-1;
            Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
            while (cnt>0 && itr.hasNext()) {
                Map.Entry<Integer, Integer> entry = itr.next();
                n1 += entry.getKey() * entry.getValue();
                cnt -= entry.getValue();
            }
            ans = Math.max(ans, (long) n1 * list.get(i)[0]);
            map.put(list.get(i)[1], map.getOrDefault(list.get(i)[1], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums1 = {1,3,3,2}; // {23,16,20,7,3}; // {2,1,14,12}; // {1,4}; //
        int[] nums2 = {2,1,3,4}; // {19,21,22,22,12}; // {11,7,13,6}; // {3,1}; //
        int k = 3; // 3; // 2; // 3;
        long ans = func3(nums1, nums2, k);
        System.out.println(ans);
        ans = func2(nums1, nums2, k);
        System.out.println(ans);
    }
}
