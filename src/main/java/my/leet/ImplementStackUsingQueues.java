package my.leet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ImplementStackUsingQueues {

    /** 标准解法 使用单个队列实现栈 */
    class MyStack {
        Queue<Integer> queue = null;

        public MyStack() {
            queue = new LinkedList<>();
        }

        /** x入队列前统计原队列元素个数，x入队列后将原本队列元素出队列放至队列末尾，使新入队列元素为对头，实现FIFO */
        public void push(int x) {
            int l = queue.size();
            queue.add(x);
            while (l>0) {
                Integer tmp = queue.poll();
                queue.add(tmp);
                l--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
