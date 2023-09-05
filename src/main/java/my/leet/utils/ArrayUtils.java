package my.leet.utils;

public class ArrayUtils {

    public static void printArray(int[] array) {
        if (array.length>0) {
            System.out.printf("[%d", array[0]);
        } else {
            System.out.printf("[");
        }
        for (int i = 1; i < array.length; i++) {
            System.out.printf(", %d", array[i]);
        }
        System.out.println("]");
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public static void printTransposeArray(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int[][] t = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t[i][j] = array[j][i];
            }
        }
        printArray(t);
    }

    public static void printArray(char[] array) {
        if (array.length>0) {
            System.out.printf("[%c", array[0]);
        } else {
            System.out.printf("[");
        }
        for (int i = 1; i < array.length; i++) {
            System.out.printf(", %c", array[i]);
        }
        System.out.println("]");
    }

    public static void printArray(Object[] array) {
        if (array.length>0) {
            System.out.printf("[%s ", array[0].toString());
        } else {
            System.out.printf("[");
        }
        for (int i = 1; i < array.length; i++) {
            System.out.printf(", %s", array[i].toString());
        }
        System.out.println("]");
    }

}
