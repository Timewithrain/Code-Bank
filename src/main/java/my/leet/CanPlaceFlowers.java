package my.leet;

/** 605. 种花问题 */
public class CanPlaceFlowers {

    static boolean func(int[] flowerbed, int n) {
        int l = flowerbed.length;
        if (l==1) return flowerbed[0] == 0 ? n <= 1 : n == 0;
        int can = 0;
        for (int i = 0; i < l; i++) {
            if ( flowerbed[i]==0 &&
                    (i == 0 || (i>0 && flowerbed[i-1]==0)) &&
                    ((i == l-1 || (i<l-1 && flowerbed[i+1]==0)))) {
                can += 1;
                flowerbed[i] = 1;
            }
            if (can >= n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1}; // {1,0,0,0,0,1,0,1};
        int n = 0;
        System.out.println(func(flowerbed, n));
    }
}
