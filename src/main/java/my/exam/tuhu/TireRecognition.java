package my.exam.tuhu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 3. 轮胎匹配，考察正则表达式
 * 通过：1.03%
 */
public class TireRecognition {

    static boolean match(int[] tw, int w) {
        boolean matchW = false;
        for (int i = 0; i < tw.length; i++) {
            if (tw[i] == w) {
                matchW = true;
                break;
            }
        }
        return matchW;
    }

    static ArrayList<String> func(String regex, String query) {
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher1 = pattern1.matcher(query);
        ArrayList<String> tmp1 = new ArrayList<>();
        while (matcher1.find()) {
            tmp1.add(matcher1.group());
        }
        return tmp1;
    }

    static ArrayList<String> fetchTireSize (int[] tw, int[] ta, int[] tr, String query) {
        ArrayList<String> ans = new ArrayList<>();
        String regex1 = "\\d{5}[Rr]\\d{2}";
        ArrayList<String> extract1 = func(regex1, query);
        for (int i = 0; i < extract1.size(); i++) {
            String s = extract1.get(i);
            int w = Integer.parseInt(s.substring(0, 3));
            int a = Integer.parseInt(s.substring(3, 5));
            int r = Integer.parseInt(s.substring(6, 8));
            if (match(tw, w) && match(ta, a) && match(tr, r)) {
                ans.add(w+"/"+a+"R"+r);
            }
        }

        String regex2 = "\\d{3}[^a-zA-z0-9]\\d{2}[Rr]\\d{2}";
        ArrayList<String> extract2 = func(regex2, query);
        for (int i = 0; i < extract2.size(); i++) {
            String s = extract2.get(i);
            int w = Integer.parseInt(s.substring(0, 3));
            int a = Integer.parseInt(s.substring(4, 6));
            int r = Integer.parseInt(s.substring(7, 9));
            if (match(tw, w) && match(ta, a) && match(tr, r)) {
                ans.add(w+"/"+a+"R"+r);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tw = {185, 195, 205, 215, 225, 235, 245, 255, 265, 275};
        int[] ta = {30, 35, 40, 45, 50, 55, 60, 65, 70};
        int[] tr = {14, 15, 16, 17, 18, 19, 20, 21};
        String query = "马牌18560R14, 固特异235/55R17, 三星195/60R21";
        ArrayList<String> ans = fetchTireSize(tw, ta, tr, query);
        System.out.println(ans);
    }
}
