package my.leet;

import my.leet.utils.ArrayUtils;

/** 58. 最后一个单词的长度 */
public class LengthOfLastWord {

    static int func(String s) {
        int ans = 0;
        String[] words = s.split(" ");
        int l = words.length;
        String last = words[l-1];
        ans = last.length();
        return ans;
    }

    static int func2(String s) {
        int l = s.length();
        int i = l-1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') break;
        }
        int j = i;
        for (; j >= 0; j--) {
            if (s.charAt(j) == ' ') break;
        }
        return i-j;
    }

    public static void main(String[] args){
        String s = "   fly me   to   the moon  "; // "hello world"; //
        int ans = func(s);
        System.out.println(ans);
        ans = func2(s);
        System.out.println(ans);
    }
}
