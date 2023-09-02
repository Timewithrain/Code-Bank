package my.leet;

public class RepeatedSubstringPattern {

    static boolean func(String s) {
        int len = s.length();
        boolean ans = false;
        for (int l = 1; l <= len/2; l++) {  // 每个子串
            if (len%l != 0 || ans) continue;
            boolean match = true;
            for (int i = 0; i < l; i++) {  // 子串的每个字符
                if (!match) break;
                for (int j = 1; j < len/l; j++) {  // 每个字符与原串匹配
                    if (s.charAt(i)!=s.charAt(j*l+i)) {
                        match = false;
                        break;
                    }
                    if (i==l-1 && j*l+i==len-1) {
                        ans = true;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababba";
        System.out.println(func(s));
    }
}
