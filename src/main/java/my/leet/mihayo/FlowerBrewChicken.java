package my.leet.mihayo;

/**
 * 米小游准备做一些甜甜花酿鸡。
 * 已知做一个甜甜花酿鸡，需要 22 个甜甜花和 22 个禽肉。米小游现在有 a 个甜甜花， b 个禽肉，以及 c 个万能食材(每个万能食材可以当作一个甜甜花或者一个禽肉)
 * 米小游想知道，自己最多可以做多少只甜甜花酿鸡?
 */
public class FlowerBrewChicken {

    static int func(int a, int b, int c) {
        int base = Math.min(a/22, b/22);
        a -= base*22;
        b -= base*22;
        int extra = 0;
        if (Math.abs(a-b) <= c) {
            c = (c - Math.abs(a-b))/2;
            extra = (Math.max(a, b) + c)/22;
        } else {
            extra = (Math.min(a, b) + c)/22;
        }
        return base + extra;
    }

    public static void main(String[] args) {
        int ans = func(123, 122, 22);
        System.out.println(ans);
    }

}
