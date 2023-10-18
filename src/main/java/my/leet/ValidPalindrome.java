package my.leet;

/** 125. 验证回文串 */
public class ValidPalindrome {

    static boolean func(String s) {
        boolean ans = true;
        int l = 0, r = s.length()-1;
        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            while (!(Character.isLetter(cl) || Character.isDigit(cl)) && l < r) cl = s.charAt(++l);
            while (!(Character.isLetter(cr) || Character.isDigit(cr)) && l < r) cr = s.charAt(--r);
            cl = Character.isLetter(cl) ? Character.toLowerCase(cl) : cl;
            cr = Character.isLetter(cr) ? Character.toLowerCase(cr) : cr;
            if (l < r && cl != cr) {
                ans = false;
                break;
            }
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "cc"; // "A man, a plan, a canal: Panama"; // " "; // "0p"; // "race a car"; //
        boolean ans = func(s);
        System.out.println(ans);
    }
}
