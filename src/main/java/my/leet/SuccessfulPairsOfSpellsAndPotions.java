package my.leet;

import java.util.Arrays;

/** 2300. 咒语和药水的成功对数 */
public class SuccessfulPairsOfSpellsAndPotions {

    static int fit(int spell, long success, int[] potions, int i) {
        if (i == 0) return (long) spell * potions[i] >= success ? 0 : -1;
        if ((long) spell * potions[i-1] >= success) return 1;
        else if ((long) spell * potions[i] < success) return -1;
        else return 0;
    }

    static int[] func(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            int mid = 0;
            while (l <= r) {
                mid = (l + r) / 2;
                int flag = fit(spells[i], success, potions, mid);
                if (flag == 0) {
                    pairs[i] = m - mid;
                    break;
                } else if (flag == 1) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] spells = {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}; // {1,2,3,4,5,6,7}; //
        int[] potions = {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}; // {1,2,3,4,5,5,5,6,7};
        long success = 10000000000L; // 25; //
        int[] pairs = func(spells, potions, success);
        System.out.println(Arrays.toString(pairs));
    }
}
