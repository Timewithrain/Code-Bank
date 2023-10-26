package my.leet;

import java.util.ArrayList;

/** 155. 最小栈 */
public class MinStack {

    private ArrayList<Integer> stack;
    private ArrayList<Integer> assist;
    private int min;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.assist = new ArrayList<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.add(val);
        if (val < min) min = val;
        assist.add(min);
    }

    public void pop() {
        stack.remove(stack.size()-1);
        assist.remove(assist.size()-1);
        this.min = assist.size() > 0 ? assist.get(assist.size()-1) : Integer.MAX_VALUE;
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return assist.get(assist.size()-1);
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
