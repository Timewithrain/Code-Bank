package my.leet;

import java.util.Arrays;

/** 675. 爱吃香蕉的珂珂 */
public class KoKoEatingBananas {

    static int bs(int[] piles, int target) {
        int ans = -1;
        int len = piles.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (piles[mid] >= target) {
                ans = mid;
                if (piles[mid] > target) r = mid - 1;
                else break;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static int eatOffCost(int[] piles, int k) {
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            int n = 0;
            while ((long) n * k < piles[i]) {
                n += 1;
            }
            ans += n;
        }
        return ans;
    }

    // 两次二分法实现
    static int eatOffCost2(int[] piles, int k) {
        int ans = 0;
        int n = bs(piles, k);
        ans += n;
        for (int i = n; i < piles.length; i++) {
            ans += (int) Math.ceil((double) piles[i] / (double) k);
        }
        return ans;
    }

    static int func(int[] piles, int h) {
        int ans = 0;
        int len = piles.length;
        Arrays.sort(piles);
        int l = 1, r = piles[len-1];
        while (l <= r) {
            int mid = (l + r) / 2;
            int c1 = eatOffCost2(piles, mid);
            int c2 = mid>1 ? eatOffCost2(piles, mid-1) : Integer.MAX_VALUE;
            if (c1 <= h && c2 > h) {
                ans = mid;
                break;
            } else if (c2 <= h){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {2,2}; // {1,1,1,999999999}; // {3,6,7,11}; //
        int h = 2; // 10; // 8; //
        int ans = func(piles, h);
        System.out.println(ans);
    }
}
