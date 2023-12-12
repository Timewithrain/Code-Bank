package my.leet;

import java.util.LinkedList;

public class Dota2Senate {

    static String func(String senate) {
        int l = senate.length();
        LinkedList<Integer> R = new LinkedList<>();
        LinkedList<Integer> D = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            if (senate.charAt(i) == 'R') R.add(i);
            else D.add(i);
        }
        while (R.size()>0 && D.size()>0) {
            int r = R.poll();
            int d = D.poll();
            if (r < d) {
                R.add(l+r);
            } else {
                D.add(l+d);
            }
        }
        return R.size()>0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {

    }
}
