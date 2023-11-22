package my.leet;

/** 1768. 交替合并字符串 */
public class MergeStringsAlternately {

    static String func(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i1 = 0, l1 = word1.length();
        int i2 = 0, l2 = word2.length();
        while (i1 < l1 || i2 < l2) {
            if (i1 < l1) sb.append(word1.charAt(i1++));
            if (i2 < l2) sb.append(word2.charAt(i2++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
