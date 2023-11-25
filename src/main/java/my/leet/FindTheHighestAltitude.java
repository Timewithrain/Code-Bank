package my.leet;

/** 1732. 找到最高海拔 */
public class FindTheHighestAltitude {

    static int func(int[] gain) {
        int ans = 0, t = 0, l = gain.length;
        for (int i = 0; i < l; i++) {
            t += gain[i];
            ans = Math.max(ans, t);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
