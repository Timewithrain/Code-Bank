package my.leet;

import java.util.PriorityQueue;

/** 2462. 雇佣K位工人的总代价 */
public class TotalCostToHireKWorkers {

    static long func(int[] costs, int k, int candidates) {
        long ans = 0;
        int l = costs.length;
        PriorityQueue<Integer> prev = new PriorityQueue<>();
        PriorityQueue<Integer> tail = new PriorityQueue<>();
        int left = 0, right = 0;
        for (int i = 0; i < candidates; i++) {
            if (i < l-1-i) {
                prev.add(costs[i]);
                left = i;
                tail.add(costs[l-1-i]);
                right = l-1-i;
            } else if (i == l-1-i){
                prev.add(costs[i]);
                left = i;
            } else {
                break;
            }
        }
        while (k > 0 && !prev.isEmpty() && !tail.isEmpty()) {
            if (prev.element() <= tail.element()) {
                ans += prev.poll();
                if (left+1 < right) prev.add(costs[++left]);
            } else {
                ans += tail.poll();
                if (left < right-1) tail.add(costs[--right]);
            }
            --k;
        }
        while (k > 0 && !prev.isEmpty()) {ans += prev.poll(); --k;}
        while (k > 0 && !tail.isEmpty()) {ans += tail.poll(); --k;}
        return ans;
    }

    public static void main(String[] args) {
        int[] costs = {60,87,94,42,12,60};
        int k = 5;
        int candidate = 4;
        long ans = func(costs, k, candidate);
        System.out.println(ans);
    }
}
