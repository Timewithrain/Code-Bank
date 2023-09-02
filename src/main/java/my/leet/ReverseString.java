package my.leet;

import my.leet.utils.ArrayUtils;

/**
 * 344. 反转字符串
 */
public class ReverseString {

    static void func(char[] s) {
        int i = 0;
        int j = s.length-1;
        char t;
        for (; i < j; i++,j--) {
            t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        func(s);
        ArrayUtils.printArray(s);
    }

}
