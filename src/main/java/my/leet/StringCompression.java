package my.leet;

/** 443. 压缩字符串 */
public class StringCompression {

    static int func(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int l = chars.length;
        int ans = 0, tmp = 1, idx = 0;
        for (int i = 1; i < l; i++) {
            if (chars[i] == chars[i-1]) {
                tmp++;
            } else {
                if (tmp>1) {
                    String s = Integer.toString(tmp);
                    sb.append(chars[idx]).append(s);
                    ans += s.length() + 1;
                } else {
                    sb.append(chars[idx]);
                    ans += 1;
                }
                tmp = 1;
                idx = i;
            }
        }
        if (tmp>1) {
            String s = Integer.toString(tmp);
            sb.append(chars[idx]).append(s);
            ans += s.length() + 1;
        } else {
            sb.append(chars[idx]);
            ans += 1;
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'}; // {'a'}; //
        int ans = func(chars);
        System.out.println(ans);
    }
}
