package my.exam.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小红的修改排列
 * 小红有一个长度为n的乱序数组，ta希望对数组中的任意两个数做一次交换，使得排列中能够找出一个长度为k的排列
 * 排列：一个长度为k的排列是一个长度为k的数组，其中包含1~k的所有整数，每个整数只出现一次
 * 若能够找到这样的排列，输出YES并在下一排输出x取值为[0，1]代表需要交换的两数的位置，否则输出NO
 * 输入：
 * 5 4
 * 1 2 5 4 3
 * 输出：
 * YES
 * 1
 * 3 5
 * 通过：6%
 */
public class HongChangePermutation {

    static ArrayList<Integer[]> getMatch(int[] arr, int i, int j) {
        ArrayList<Integer[]> a = new ArrayList<>();
        ArrayList<Integer[]> ans = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            a.add(new Integer[]{arr[k], k+1-i});
        }
//        a.sort((a1, a2) -> a1[0] - a2[0]);
        for (int k = 0; k < a.size(); k++) {
            if (a.get(k)[0] != a.get(k)[1]) {
                ans.add(new Integer[]{k+1, a.get(k)[0]});
            }
        }
        return ans;
    }

    static void func(int[] arr, int k) {
        int l = arr.length;
        ArrayList<Integer[]> ans = null;
        for (int j = k; j <= l; j++) {
            ArrayList<Integer[]> match = getMatch(arr, j-k, j-1);
            if (match.size()<2 || (match.size()==2 && match.get(0)[1]==match.get(1)[0])) {
                ans = match;
                break;
            }
        }
        if (ans != null) {
            System.out.println("YES");
            if (ans.size()==0) {
                System.out.println(0);
            } else if (ans.size()==1) {
                System.out.println(1);
                int pos1 = 0, pos2 = 0;
                for (int i = 0; i < l; i++) {
                    if (arr[i] == ans.get(0)[0]) {
                        pos1 = i+1;
                    }
                    if (arr[i] == ans.get(0)[1]) {
                        pos2 = i+1;
                    }
                }
                System.out.println(pos1 + " " + pos2);
            } else {
                System.out.println(1);
                int pos1 = 0, pos2 = 0;
                for (int i = 0; i < l; i++) {
                    if (arr[i] == ans.get(0)[0]) {
                        pos1 = i+1;
                    }
                    if (arr[i] == ans.get(0)[1]) {
                        pos2 = i+1;
                    }
                }
                System.out.println(pos1 + " " + pos2);
            }
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        func(arr, k);
    }
}
