package my.exam.ccb;

import java.util.ArrayList;

/**
 * 2. 小红的交错RED
 * 给定一个3n长度字符串，判断这个字符串能否由n个"red"交错构成
 * 输入：
 * rreded
 * 输出：
 * true
 * 输入；
 * rededr
 * 输出：
 * false
 */
public class CrossingRed {

    public boolean isRed (String s) {
        boolean ans = true;
        ArrayList<Integer> R = new ArrayList<>();
        ArrayList<Integer> E = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'r') R.add(i);
            else if (s.charAt(i) == 'e') E.add(i);
            else if (s.charAt(i) == 'd') D.add(i);
        }
        if (R.size() != E.size() || E.size() != D.size()) return false;
        for (int i = 0; i < R.size(); i++) {
            int r = R.get(i);
            int e = E.get(i);
            int d = D.get(i);
            if (!(r < e && e < d)) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
