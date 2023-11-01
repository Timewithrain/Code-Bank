package my.base;

import java.lang.reflect.Field;
import java.util.HashSet;

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

    static void test2() {
        String a = new String("abc");
        System.out.println(a=="abc");  // false，a位于堆区，"abc"位于常量池
        a = a.intern();
        System.out.println(a=="abc");  // true，a被替换为常量池中的"abc"字符串

        HashSet<String> set = new HashSet<>();
        set.add(a);
        System.out.println(set.toString());
        a = a + "de";  // 本质上创建了一个StringBuilder执行了两次append操作，并使用toString返回了一个新的字符串，set中的字符串不变
        System.out.println(set.toString());
    }

    static void test3() throws NoSuchFieldException, IllegalAccessException {
        // 尝试修改String
        String s = "abc";
        System.out.println("反射前的值: " + s);
        System.out.println("反射前的hash: " + s.hashCode());
        // 修改value
        Field field = s.getClass().getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[]) field.get(s);
        value[1] = 'c';
        System.out.println("反射修改value后的值: " + s);
        System.out.println("反射修改value后的hash: " + s.hashCode());  // HashCode没有改变，因为String中hashcode仅在其值不为0时计算

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        test3();
    }
}
