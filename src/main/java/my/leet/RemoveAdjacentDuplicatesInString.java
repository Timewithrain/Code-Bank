package my.leet;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveAdjacentDuplicatesInString {

    static String func(String s) {
        StringBuilder sb = new StringBuilder();
        Character[] stack = new Character[s.length()];
        int top = 0;
        stack[top++] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (top>0 && stack[top-1] == s.charAt(i)) {
                top -= 1;
            } else {
                stack[top++] = s.charAt(i);
            }
        }
        for (int i=0; i<top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String ans = func(s);
        System.out.println(ans);
    }

}
