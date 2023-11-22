package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 68. 文本左右对齐
 * 将两处字符串拼接改为链式编程后用例耗时从8ms降低为1ms
 */
public class TextJustification {

    static String justify(StringBuilder sb, int maxWidth) {  // 对称化行
        if (sb.length() == maxWidth) return sb.toString();
        int l = maxWidth - sb.length();
        String[] strs = sb.toString().split(" ");
        if (strs.length == 1) return justifyLast(sb, maxWidth);
        sb = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            StringBuilder space = new StringBuilder();
            for (int J = 0; J < l/(strs.length-1); J++) {  // 计算空格
                space.append(' ');
            }
            if ((l%(strs.length-1)!=0) && i <= l%(strs.length-1)) space.append(' ');
            sb.append(" ").append(space).append(strs[i]);  // 链式编程效率较字符串连接更高，替换sb.append(" "+space+strs[i]);
        }
        return sb.toString();
    }

    static String justifyLast(StringBuilder sb, int maxWidth) {  // 对称化仅包含一个词的行
        while (sb.length() < maxWidth) {
            sb.append(' ');
        }
        return sb.toString();
    }

    static List<String> func(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int l = words.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if (sb.length() == 0) {
                sb.append(words[i]);
            } else if (sb.length() + words[i].length() + 1 <= maxWidth) {
                sb.append(" ").append(words[i]);
            } else {
                ans.add(justify(sb, maxWidth));
                sb = new StringBuilder(words[i]);
            }
        }
        if (sb.length() > 0) {
            ans.add(justifyLast(sb, maxWidth));
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> ans = func(words, maxWidth);
        System.out.println(ans);
    }
}
