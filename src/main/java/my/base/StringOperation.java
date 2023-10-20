package my.base;

/** 测试String操作 */
public class StringOperation {

    /** 将s首字母大写 */
    static void test1() {
        String s = "abc";
        System.out.println(String.format("%c%s", Character.toUpperCase(s.charAt(0)) , s.substring(1)));
        System.out.println(s.toUpperCase().charAt(0) + s.substring(1));
        System.out.println(Character.toUpperCase(s.charAt(0)) + s.substring(1));
        System.out.println(s.substring(0,1).toUpperCase() + s.substring(1));
    }

    public static void main(String[] args) {
        test1();
    }
}
