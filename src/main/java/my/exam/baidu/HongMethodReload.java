package my.exam.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小红的方法重载
 * 实现以下函数功能：
 * 1. 创建函数
 * 输入字符串"Type Name(Var1 a1,Var2 a2, ...)" 表示函数类型、函数名、参数列表
 * 若成功创建，输出"ok."
 * 若函数已存在，输出"method Name is already defined.."
 * 2. 调用函数
 * 输入字符串"name(Var1,Var2, ...)" 表示调用时的函数名和参数类型列表
 * 若函数存在，则成功调用输出"ok."
 * 若函数不存在，输出"cannot find symbol name."
 * 若参数类型不匹配，输出"method name cannot be applied to given types."
 * 输入说明：
 * 第一行：n，表示接下来有n次输入
 * 一个整数，代表创建或调用
 * 接下来n行，每行为一个字符串，表示函数的创建或调用
 * 输入：
 * 2
 * 1
 * int add(int a,int b)
 * 2
 * add(int,int)
 * 输出：
 * ok.
 * ok.
 * 未提交
 */
public class HongMethodReload {

    static ArrayList<Method> methods = new ArrayList<>();

    static ArrayList<String> result = new ArrayList<>();

    static void createMethod(String str) {
        boolean ans = true;
        String[] s = str.substring(0, str.length()-1).split("\\(");
        String type = s[0].split(" ")[0];
        String name = s[0].split(" ")[1];
        String[] params = s[1].split(",");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].split(" ")[0];
        }
        Method method = new Method(type, name, params);
        for (Method m : methods) {
            if (m.equals(method)) {
                ans = false;
                break;
            }
        }
        if (ans) {
            result.add("ok.");
            methods.add(method);
        } else {
            result.add("method " + name + " is already defined..");
        }
    }

    static void invoke(String str) {
        boolean ans = false;
        boolean hasName = false;
        String[] s = str.substring(0, str.length()-1).split("\\(");
        String name = s[0];
        String[] params = s[1].split(",");
        for (int i = 0; i < methods.size(); i++) {
            Method m = methods.get(i);
            if (m.name.equals(name)) {
                hasName = true;
                if (m.params.length == params.length) {
                    boolean isSame = true;
                    for (int j = 0; j < params.length; j++) {
                        if (!m.params[j].equals(params[j])) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        ans = true;
                        break;
                    }
                }
            }
        }
        if (ans) {
            result.add("ok.");
        } else {
            if (hasName) {
                result.add("method " + name + " cannot be applied to given types.");
            } else {
                result.add("cannot find symbol " + name + ".");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int op = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            if (op==1) {
                createMethod(str);
            } else {
                invoke(str);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result.get(i));
        }
    }
}

class Method {

    String type;

    String name;

    String[] params;

    public Method(String type, String name, String[] params) {
        this.type = type;
        this.name = name;
        this.params = params;
    }

    public boolean equals(Method o1) {
        if (this.type.equals(o1.type) && this.name.equals(o1.name) && this.params.length == o1.params.length) {
            for (int i = 0; i < this.params.length; i++) {
                if (!this.params[i].equals(o1.params[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}