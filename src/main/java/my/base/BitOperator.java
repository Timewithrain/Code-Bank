package my.base;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/** 位运算符 */
public class BitOperator {

    static void test1() {
        // 左移，绝对值增大2^n倍
        int a = 2;
        int c = 1;
        int b = a << c;
        System.out.println(a + "左移" + c + "位: "+ a + " << 1 = " + b);
        a = -2;
        b = a << c;
        System.out.println(a + "左移" + c + "位: "+ a + " << 1 = " + b);
        // 右移，符号位不变，数的绝对值缩小2^n倍
        a = 2;
        b = a >> c;
        System.out.println(a + "右移" + c + "位: "+ a + " >> 1 = " + b);
        a = -2;
        b = a >> c;
        System.out.println(a + "右移" + c + "位: "+ a + " >> 1 = " + b);
        // 无符号右移，连带符号位同时右移，符号位补0，正数缩小2^n倍，负数变为一个很大的正数
        a = 2;
        b = a >>> c;
        System.out.println(a + "无符号右移" + c + "位: "+ a + " >>> 1 = " + b);
        a = -2;
        b = a >>> c;
        System.out.println(a + "无符号右移" + c + "位: "+ a + " >>> 1 = " + b);
    }

    public static void main(String[] args){
        test1();
    }
}
