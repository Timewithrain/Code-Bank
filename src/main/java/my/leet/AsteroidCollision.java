package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;

/** 735. 小行星碰撞 */
public class AsteroidCollision {

    static int[] func(int[] asteroids) {
        int l = asteroids.length;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(asteroids[0]);
        for (int i = 1; i < l; i++) {
            if (arr.size() > 0 && arr.get(arr.size()-1) > 0 && asteroids[i] < 0) {
                int result = arr.get(arr.size()-1) + asteroids[i];
                if (result == 0) {
                    arr.remove(arr.size()-1);
                } else if (result < 0){
                    arr.remove(arr.size()-1);
                    i--;
                }
            } else {
                arr.add(asteroids[i]);
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] asteroids = {1, -2, -2, -2}; // {-2,-2,1,-2}; // {8, -8}; // {-2,-2,1,-1}; //
        int[] ans = func(asteroids);
        ArrayUtils.printArray(ans);
    }
}
