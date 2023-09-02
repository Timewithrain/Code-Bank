package my.leet;

/** 409. 最长回文串 */
public class LongestPalindrome {

    static int func(String s) {
        int[] vocab = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') vocab[c-'a']+=1;
            if ('A' <= c && c <= 'Z') vocab[c-'A' + 26]+=1;
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < vocab.length; i++) {
            if (vocab[i]%2==0) {
                even += vocab[i];  // 偶数个字符可以全部用来构成回文串
            } else {
                even += odd!=0 ? odd - 1 : 0;  // 奇数个字符减去一个用来构成回文串
                odd = vocab[i];
            }
        }
        return odd + even;
    }

    public static void main(String[] args) {
        String s = "abccccdd"; // "a"; // "aaaaaccccc"; //
        System.out.println(func(s));
    }
}
