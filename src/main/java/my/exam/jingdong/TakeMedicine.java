package my.exam.jingdong;

import java.util.Scanner;

/**
 * 京东2024校招笔试题
 * 2.吃药问题
 * 给定n种症状，m种药，每种药有两种效果，第一是消除n种症状中的某些症状，第二是造成n种症状中的某些症状
 * 小红吃了q种药，问每吃下一种药，她所具备的症状数量是多少
 * 输入:
 * 4
 * 1001
 * 3
 * 1101
 * 0000
 * 1100
 * 0001
 * 1001
 * 0010
 * 3
 * 2
 * 1
 * 3
 * 输出:
 * 1
 * 0
 * 1
 */
public class TakeMedicine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        // 1. 用一个数组记录现有的症状，1表示有症状，0表示无症状
        int[] symptom = new int[n];
        String s = in.nextLine();
        for (int i = 0; i < n; i++) {
            symptom[i] = s.charAt(i) == '1' ? 1 : 0;
        }
        // 2. 用一个三维数组记录药的效果，第一维表示第几种药，第二维表示第几种效果，第三维表示第几种症状
        int m = in.nextInt();
        in.nextLine();
        int[][][] medicine = new int[m][2][n];
        for (int i = 0; i < m; i++) {
            s = in.nextLine();
            // 第i种药能消除的症状
            for (int j = 0; j < n; j++) {
                medicine[i][0][j] = s.charAt(j) == '1' ? 1 : 0;
            }
            s = in.nextLine();
            // 第i种药造成的症状
            for (int j = 0; j < n; j++) {
                medicine[i][1][j] = s.charAt(j) == '1' ? 1 : 0;
            }
        }
        // 3. 用一个数组记录小红吃的药
        int q = in.nextInt();
        in.nextLine();
        int[] pres = new int[q];
        for (int i = 0; i < q; i++) {
            pres[i] = in.nextInt();
        }

        // 4. 模拟小红吃药的过程
        for (int i = 0; i < q; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                symptom[j] = medicine[pres[i]-1][0][j]==1 ? 0 : symptom[j];
            }
            for (int j = 0; j < n; j++) {
                symptom[j] = medicine[pres[i]-1][1][j]==1 ? 1 : symptom[j];
                if (symptom[j] == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
