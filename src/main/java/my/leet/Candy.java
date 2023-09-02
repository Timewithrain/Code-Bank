package my.leet;

/** 135. 分发糖果 */
public class Candy {

    static int func(int[] ratings) {
        int l = ratings.length;
        int ans = l;
        int[] forward = new int[l];
        int[] backward = new int[l];
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i-1]) {
                forward[i] = forward[i-1] + 1;
            }
            if (ratings[l-i-1] > ratings[l-i]) {
                backward[l-i-1] = backward[l-i] + 1;
            }
        }
        for (int i = 0; i < l; i++) {
            ans += Math.max(forward[i], backward[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ratings =  {1,2,2}; // {1,0,2}; // {1,2,87,87,87,2,1}; // {1,3,2,2,1}; //
        System.out.println(func(ratings));

    }
}
