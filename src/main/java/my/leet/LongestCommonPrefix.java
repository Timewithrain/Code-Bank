package my.leet;

/** 14.最长公共前缀 */
public class LongestCommonPrefix {

    static String func(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int l = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            Character c = strs[0].charAt(i);
            for (int j = 1; j < l; j++) {
                if (strs[j].length() == i || strs[j].charAt(i)!=c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"}; // {"flower", "flow", "flight"};
        String ans = func(strs);
        System.out.println(ans);
    }
}
