package my.exam.meituan2;

import java.util.HashSet;
import java.util.Scanner;

public class MeiSugar {

    static int func(int[] array) {
        HashSet<Integer[]> set = new HashSet<>();
        int ans = 0;
        for (int i = 1; i < array.length; i++) {
            Integer[] emp1 = {array[i-1], array[i]};
            Integer[] emp2 = {array[i], array[i-1]};
            if (!set.contains(emp1) && !set.contains(emp2)) {
                 ans++;
            } else {
                set.add(emp1);
                set.add(emp2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(func(array));
    }
}
