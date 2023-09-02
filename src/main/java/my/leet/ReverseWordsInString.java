package my.leet;

/**
 * 151. 反转字符串里的单词
 */
public class ReverseWordsInString {

    static String func(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length-1; i >=0 ; i--) {
            if (array[i].length()>0) {
                sb.append(array[i]+" ");
            }
        }
        return sb.substring(0, sb.length()-1);
    }

    public static void main(String[] args) {
        String s = "  hello world "; // "the sky is blue";
        String ans = func(s);
        System.out.println(ans);
    }

}
