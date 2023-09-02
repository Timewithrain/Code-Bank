package my.leet;

import java.util.Arrays;

/** 455. 分发饼干 */
public class AssignCookies {

    static int func(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[j]) {
                j++;
                if (j == g.length) {
                    return j;
                }
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] g =  {1,2}; // {1,2,3}; //
        int[] s =  {1,2,3}; // {1,1}; //
        System.out.println(func(g, s));
    }
}
