package my.leet;

import java.util.LinkedList;

public class ValidBracket {

    static boolean func(String s) {
        boolean ans = true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c=='[' || c=='{' || c=='(') {
                stack.push(c);
            } else {
                Character cc = stack.poll();
                if (cc==null || (c==']' && cc!='[') || (c=='}' && cc!='{') || (c==')' && cc!='(')) {
                    ans = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) ans = false;
        return ans;
    }

    public static void main(String[] args){
        String s = "";
        boolean ans = func(s);
        System.out.println(ans);
    }

}
