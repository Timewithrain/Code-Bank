package my.leet;

/** 28. KMP算法 */
public class FindTheIndexOfTheFirstOccurrenceInString {

    /** 构造next数组 */
    static int[] getNext(String s) {
        int[] next = new int[s.length()+1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i<s.length()) {
            if (j==-1 || s.charAt(i)==s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    static int func(String haystack, String needle) {
        int[] next = getNext(needle);
        int j = 0;
        int i = 0;
        while (i<haystack.length() && j<needle.length()) {
            if (j==-1 || haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j==needle.length() ? i-j : -1;
    }

    public static void main(String[] args) {
        String s1 = "sadbutsad";  //"leetcode";  //
        String s2 = "sad"; // "leeto";  //
        int ans = func(s1, s2);
        System.out.println(ans);;
    }
}
