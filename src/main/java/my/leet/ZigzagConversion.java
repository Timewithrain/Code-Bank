package my.leet;

/** 6. Z字形变换 */
public class ZigzagConversion {

    static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int cycle = numRows + numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i+=cycle) {
            sb.append(s.charAt(i));
        }
        for (int i = numRows-2; i > 0; i--) {
            for (int j = numRows-1; j - i < s.length(); j+=cycle) {
                sb.append(s.charAt(j-i));
                if (j+i < s.length())sb.append(s.charAt(j+i));
            }
        }
        for (int i = numRows-1; i < s.length(); i+=cycle) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING"; // "ABCDE"; // "A"; //
        int numRows = 3; // 4; // 3; //
        String ans = convert(s, numRows);
        System.out.println(ans);
    }
}
