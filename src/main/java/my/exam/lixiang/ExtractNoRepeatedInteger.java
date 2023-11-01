package my.exam.lixiang;

import java.util.Scanner;

public class ExtractNoRepeatedInteger {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        n = n>0 ? n : -n;
        int[] map = new int[10];
        int ans = 0;
        while (n>0) {
            int i = n % 10;
            if (map[i]==0) {
                map[i] = 1;
                ans = 10 * ans + i;
            }
            n = n / 10;
        }
        System.out.println(ans);
    }
}
