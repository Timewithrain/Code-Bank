package my.leet;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    static List<Boolean> func(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int aim = candies[0];
        for (int i = 1; i < candies.length; i++) {
            aim = Math.max(aim, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[i]+extraCandies >= aim);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
