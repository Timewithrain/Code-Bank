package my.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PhoneNumberCombination {


    static ArrayList<String> recall(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        for (int i = 0; i < digits.length(); i++) {
            String v = map.get(digits.charAt(i));
            if (ans.size()==0) {
                for (int j = 0; j < v.length(); j++) {
                    ans.add(v.charAt(j)+"");
                }
                continue;
            }
            ArrayList tmp = new ArrayList<>(ans);
            ans.clear();
            for (int j = 0; j < tmp.size(); j++) {
                for (int k = 0; k < v.length(); k++) {
                    ans.add(tmp.get(j) + (v.charAt(k)+""));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String digits = "2";
        ArrayList<String> ans = recall(digits);
        System.out.println(ans);
    }

}
