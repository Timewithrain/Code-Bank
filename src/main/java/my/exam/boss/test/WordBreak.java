package my.exam.boss.test;

import java.util.ArrayList;

public class WordBreak {

    static boolean func(String s, ArrayList<String> wordDict) {
        int l = s.length();
        boolean[] ans = new boolean[l+1];
        ans[0]= true;
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && ans[j]) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[l];
    }

    public static void main(String[] args) {

    }
}
