package my.leet;


import java.util.Stack;

public class ImplementQueueUsingStacks {

    /** 使用两个栈实现队列 */
    static class MyQueue {
        Stack<Integer> inStack = null;  // 实现入队列操作
        Stack<Integer> outStack = null;  // 实现出队列操作

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.add(x);
        }

        public int pop() {
            if (!outStack.isEmpty()) return outStack.pop();  // 出栈不为空，则直接输出
            while (!inStack.isEmpty()) {                     // 出栈为空，则将入栈元素倒入出栈再输出
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        public int peek() {
            if (!outStack.isEmpty()) return outStack.peek();  // 出栈不为空，直接peek栈顶元素
            while (!inStack.isEmpty()) {                      // 出栈为空，将入栈元素倒入出栈后，再peek栈顶元素
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
