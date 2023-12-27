package my.leet;

import java.util.LinkedList;

/** 901. 股票价格跨度 */
public class OnlineStockSpan {

    static class StockSpanner {
        LinkedList<Integer> prices;
        LinkedList<Integer> spans;

        public StockSpanner() {
            this.prices  = new LinkedList<>();
            this.spans = new LinkedList<>();
        }

        public int next(int price) {
            int span = 1;
            while (!this.spans.isEmpty() && price > this.prices.peek()) {
                this.prices.pop();
                span += this.spans.poll();
            }
            this.prices.push(price);
            this.spans.push(span);
            return span;
        }


    }

    public static void main(String[] args) {

    }
}
