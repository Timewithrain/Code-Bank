package my.leet;

public class IsSubsequence {

    static boolean func(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int i = 0;
        int j = 0;
        while (i<sl && j<tl) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i==sl;
    }

    public static void main(String[] args) {
        String s =  "abc"; // "axc"; //
        String t =  "ahbgdc"; // "ahbgdc"; //
        System.out.println(func(s, t));
    }
}
