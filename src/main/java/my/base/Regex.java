package my.base;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java正则表达式参考：https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */
public class Regex {

    /**
     * 正则表达式匹配整数
     * 参考《Thinking in Java》p296
     */
    public static void integerMatch() {
//        String regex = "[0-9]+";  // [0-9]+等效于\\d+，表示有一个或多个数字
        String regex = "\\d+";
        System.out.println("123".matches(regex));
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }

    /**
     * 单词划分
     * 参考《Thinking in Java》p301
     */
    public static void finding() {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
        int i = 0;
        // 使用i重定位搜索的起始位置
        while (m.find(i)) {
            System.out.print(m.group() + " ");
            i++;
        }
    }

    public static void main(String[] args) {
//        integerMatch();
        finding();
    }

}
