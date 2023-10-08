package my.exam.kingdee;

/**
 * 金蝶后端笔试
 * 判断回文数
 */
public class PalindromeNumber {

    /** 使用字符串反转匹配的方式实现 */
    static boolean isPalindromeNumber(long num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    /** 使用long类型反转后相等实现 */
    static boolean isPalindromeNumber2(long num) {
        if (num < 0) return false;
        long newNum = 0;
        long tmp = num;
        while (num > 0) {
            long digit = num % 10;
            newNum = newNum * 10 + digit;
            num /= 10;
        }
        return tmp == newNum;
    }

    public static void main(String[] args) {
        long num = 121;
        boolean ans = isPalindromeNumber(num);
        System.out.println(ans);
        ans = isPalindromeNumber2(num);
        System.out.println(ans);
    }
}
