package my.exam.shein;

import my.leet.utils.ArrayUtils;

import java.util.Scanner;

/**
 * 输入一个字符串s，输入一个n，将字符串按照n行m列的方式，从上到下再从下到上Z字形排列
 * 完成排列后，输出按行从上到下，按列从左至右排列的字符串
 * 例如：SHEINFORALL的排列如下
 * S   N   A
 * H I F R L
 * E   O   L
 * 输入：
 * SHEINFORALL,4
 * 输出：
 * SIRHNALELFOAL
 */
public class StringTransform {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strIn = str.split(",");
        String s = strIn[0];
        int n = Integer.parseInt(strIn[1]);
        int m = n - 2;
        if (n== 1){
            System.out.println(s);
            return;
        }
        int col = s.length() % (n+m) == 0 ? s.length() / (n+m) : s.length() % (n+m) + 1;
        int[][] arr = new int[n][col*(m+1)];

        for (int i = 0; i < s.length(); i++) {
            int start = i / (n+m);
            if (i < start*(n+m) + n){
                arr[i - start*(n+m)][start*(m+1)] = s.charAt(i);
            } else {
                arr[n-1 - (i - start*(n+m) - n)][start*(m+1) + i - start*(n+m) - n + 1] = s.charAt(i);
            }
        }
        ArrayUtils.printArray(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0){
                    sb.append((char)arr[i][j]);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
