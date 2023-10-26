package my.leet;

import java.util.ArrayList;

/** 71. 简化路径 */
public class SimplifyPath {

    static String func(String path) {
        StringBuilder sb = new StringBuilder();
        String[] nodes = path.split("/");
        ArrayList<String> stack = new ArrayList<>();
        int l = nodes.length;
        for (int i = 0; i < l; i++) {
            String str = nodes[i];
            if (str.equals("") || str.equals(".")) continue;
            if (str.equals("..")) {
                if (stack.size() > 0) stack.remove(stack.size()-1);
            } else {
                stack.add(str);
            }
        }
        sb.append("/");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            if (i < stack.size()-1) sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String path = "/a//b////c/d//././/.."; // "/a/../../b/../c//.//"; // "/../"; // "/home//foo/"; // "/home/"; // "/a/./b/../../c/"; //
        String ans = func(path);
        System.out.println(ans);
    }
}
