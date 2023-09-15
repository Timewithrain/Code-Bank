package my.exam.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一条道路其中包含n个位置可以安放路灯，有k个路灯需要安放，要让路灯尽量分散在路上的位置
 * 求相邻路灯之间的最大间隔
 */
public class RoadLight {

    static int func(int[] road, int k) {
        int n = road.length;
        int max = road[n-1];
        Arrays.sort(road);
        double[] tag = new double[k+1];

        int[] set = new int[k+1];
        for (int j = 1; j <=k; j++) {
            tag[j] = j * (double) max / (k+1);
        }
        for (int i = 1; i <= k; i++) {
            double dist = max;
            int idx = 0;
            for (int j = 0; j <n; j++) {
                if (dist > Math.abs(tag[i] - road[j])){
                    dist = Math.abs(tag[i] - road[j]);
                    idx = j;
                }
            }
            set[i] = idx;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = Math.max(ans , road[set[i]] - road[set[i-1]]);
        }
        return ans;
    }

    static int func2(int[] road, int k) {
        int n = road.length;
        Arrays.sort(road);
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt >= k) {
                break;
            }
            int left = (i==0) ? 0 : road[i-1];
            int right = (i==n-1) ? road[n-1] : road[i+1];
            max = Math.max(max, right - left);
            cnt++;
        }
        return max;
    }

    static boolean isMatch(int[] road, int k, int mid) {
        int last = road[0];
        int cnt = 1;
        for (int i = 1; i < road.length; i++) {
            if (road[i] - last >= mid) {
                last = road[i];
                cnt++;
            }
        }
        return cnt>=k;
    }

    static int func3(int[] road, int k) {
        int n = road.length;
        Arrays.sort(road);
        int left = 0;
        int right = road[n-1] - road[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isMatch(road, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] road = new int[n];
        for (int i = 0; i < n; i++) {
            road[i] = in.nextInt();
        }
        int ans = func(road, k);
        System.out.println(ans);
    }
}
