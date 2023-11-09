package my.leet;

public class AddBinary {

    static String func(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int flag = 0;
        for (int i = 0; i < Math.max(aLen, bLen); i++) {
            int ac = i<aLen ? a.charAt(aLen-1-i)-'0' : 0;
            int bc = i<bLen ? b.charAt(bLen-1-i)-'0' : 0;
            if (ac + bc + flag < 2) {
                sb.append(ac + bc + flag);
                flag = 0;
            } else if (ac + bc + flag == 2) {
                sb.append(0);
                flag = 1;
            } else {
                sb.append(1);
                flag = 1;
            }
        }
        if (flag==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010"; // "11"; //
        String b = "1011"; // "1"; //
        String ans = func(a, b);
        System.out.println(ans);
    }
}
