package my.exam.dewu;

import my.leet.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 计算分子量
 * 给定一个字符串，其为有机分子的分子式，计算其分子量
 * 分子式包含C(12),H(1),O(16),N(14)四种元素。
 * 输入：
 * C4H9OH
 * 输出：
 * 74
 */
public class CalculateMolecular {

    static int func(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('C', 0);
        map.put('H', 0);
        map.put('O', 0);
        map.put('N', 0);
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        int curNumber = 0;
        Character element = null;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (i==0) {
                element = c;
                continue;
            }
            if (Character.isLetter(c)) {
                map.put(element, map.get(element) + curNumber);
                if (i<s.length()-1 && Character.isDigit(s.charAt(i+1))) {
                    map.put(element, map.get(element));
                } else {
                    map.put(element, map.get(element) + 1);
                }
                curNumber = 0;
                element = c;
            } else {
                curNumber = 10 * curNumber + c -'0';
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey()=='C') {
                ans += entry.getValue() * 12;
            }
            if (entry.getKey()=='H') {
                ans += entry.getValue();
            }
            if (entry.getKey()=='O') {
                ans += entry.getValue() * 16;
            }
            if (entry.getKey()=='N') {
                ans += entry.getValue() * 14;
            }
        }
        return ans;
    }

    static int func2(String s) {
        int[] atom = {12, 1, 16, 14};
        String elements = "CHON";
        int ans = 0;
        int curElement = -1;
        int curNumber = -1;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (curElement!=-1) {
                    if (curNumber == -1) {
                        curNumber = 1;
                    }
                    ans += atom[curElement] * curNumber;
                    curElement = -1;
                    curNumber = -1;
                }
                curElement = elements.indexOf(c);
            } else if (Character.isDigit(c)) {
                if (curNumber == -1) {
                    curNumber = 0;
                }
                curNumber = curNumber * 10 + c - '0';
            }
        }
        if (curElement != -1) {
            if (curNumber == -1) {
                curNumber = 1;
            }
            ans += atom[curElement] * curNumber;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String molecular = in.nextLine();
        int ans = func2(molecular);
        System.out.println(ans);
    }
}
