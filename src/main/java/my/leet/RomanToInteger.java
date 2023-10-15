package my.leet;

import java.util.HashMap;

/** 13. 罗马数字转整数 */
public class RomanToInteger {

    static int func(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('M')) {
                ans += 1000;
            } else if (c.equals('D')) {
                ans += 500;
            } else if (c.equals('C')) {
                if (i<s.length()-1 && s.charAt(i+1) == 'M') {
                    ans += 900;
                    i++;
                } else if (i<s.length()-1 && s.charAt(i+1) == 'D') {
                    ans += 400;
                    i++;
                } else {
                    ans += 100;
                }
            } else if (c.equals('L')) {
                ans += 50;
            } else if (c.equals('X')) {
                if (i<s.length()-1 && s.charAt(i+1) == 'C') {
                    ans += 90;
                    i++;
                } else if (i<s.length()-1 && s.charAt(i+1) == 'L') {
                    ans += 40;
                    i++;
                } else {
                    ans += 10;
                }
            } else if (c.equals('V')) {
                ans += 5;
            } else {
                if (i<s.length()-1 && s.charAt(i+1) == 'X') {
                    ans += 9;
                    i++;
                } else if (i<s.length()-1 && s.charAt(i+1) == 'V') {
                    ans += 4;
                    i++;
                } else {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    static int func2(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);
        map.put('X', 10);map.put('L', 50);
        map.put('C', 100);map.put('D', 500);
        map.put('M', 1000);
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) <= map.get(s.charAt(i-1))) {
                ans += map.get(s.charAt(i-1));
            } else {
                ans -= map.get(s.charAt(i-1));
            }
        }
        ans += map.get(s.charAt(s.length()-1));
        return ans;
    }

    public static void main(String[] args) {
        String s = "III";  // "IV"; // "MCMXCIV"; // "LVIII";  //
        int ans = func(s);
        System.out.println(ans);
        ans = func2(s);
        System.out.println(ans);
    }
}
