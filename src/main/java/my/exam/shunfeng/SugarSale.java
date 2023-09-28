package my.exam.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 糖果促销
 * 糖果店所有的糖果都定价2元，给定n类糖果，每类糖果需要购买ai个，糖果店促销规定如果购买的所有类型的糖果总数超过bi个，则超过的糖果单价降为1元
 * 求最少需要多少钱购买所有类型的ai个糖果
 * 通过：27%
 */
public class SugarSale {

    /** 贪心法 */
    static int func2(int[][] a) {
        int ans = 0;
        int l = a.length;
        Arrays.sort(a, (a1, a2) -> a1[1] - a2[1]);
        int cnt = 0;
        int j = l - 1;
        for (int i = 0; i < l; i++) {
            if (a[i][0] == 0) continue;
            while (cnt < a[i][1]) {
                while (a[j][0]>0) {
                    a[j][0]--;
                    cnt++;
                    ans += 2;
                }
                if (a[j][0]==0) j--;
            }
            cnt += a[i][0];
            ans += a[i][0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }
        int ans = func2(a);
        System.out.println(ans);
    }
}
