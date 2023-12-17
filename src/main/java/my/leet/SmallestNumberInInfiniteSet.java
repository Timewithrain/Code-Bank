package my.leet;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/** 2336. 无限集中的最小数字 */
public class SmallestNumberInInfiniteSet {

    /** 优先级队列(堆)实现，出错 */
    static class SmallestInfiniteSetI {

        public int increment;
        public PriorityQueue<Integer> queue;

        public SmallestInfiniteSetI() {
            this.increment = 1;
            queue = new PriorityQueue<>();
        }

        public int popSmallest() {
            if (queue.isEmpty()) return increment++;
            return queue.poll();
        }

        public void addBack(int num) {
            if (num < increment) queue.add(num);
        }
    }

    /** 树集合实现 */
    static class SmallestInfiniteSetII {

        public int increment;
        public TreeSet<Integer> set;

        public SmallestInfiniteSetII() {
            this.increment = 1;
            this.set = new TreeSet<>();
        }

        public int popSmallest() {
            if (set.isEmpty()) return increment++;
            return set.pollFirst();
        }

        public void addBack(int num) {
            if (num < increment) set.add(num);
        }
    }

    public static void main(String[] args) {

    }
}


