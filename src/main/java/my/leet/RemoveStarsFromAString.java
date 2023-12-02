package my.leet;

/** 2390. 从字符串中移除星号 */
public class RemoveStarsFromAString {

    static String func(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){

    }
}
