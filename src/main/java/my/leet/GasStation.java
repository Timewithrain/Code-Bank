package my.leet;

/** 134. 加油站 */
public class GasStation {

    /** O(n^2) */
    static int func(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int cur = 0;
            while (true) {
                if (cur+gas[j] >= cost[j]) {
                    cur = cur + gas[j] - cost[j];
                    j = (j + 1) % gas.length;
                    if (j==i) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    /** o(n) */
    static int func2(int[] gas, int[] cost) {
        int[] cur = new int[gas.length];
        int rest = 0;
        for (int i = 0; i < gas.length; i++) {
            cur[i] = gas[i] - cost[i];
            rest += cur[i];
        }
        if (rest<0) return -1;
        for (int i = 0; i < cur.length;) {
            int j = i;
            int t = 0;
            while (t>=0) {
                t += cur[j];
                j = (j+1) % cur.length;
                if (j==i) {
                    return i;
                }
            }
            i = j;
        }
        return -1;
    }

    /** O(n) 系数小于func2 */
    static int func3(int[] gas, int[] cost) {
        int l = gas.length;
        int i = 0;
        int ans = -1;
        while (i < l) {
            int j = 0;
            int cur = 0;
            while (j < l) {
                if (cur + gas[(i+j)%l] >= cost[(i+j)%l]) {
                    cur = cur + gas[(i+j)%l] - cost[(i+j)%l];
                    j++;
                } else {
                    break;
                }
            }
            if (j==l) {
                ans = i;
                break;
            } else {
                i += j + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] gas =  {1,2,3,4,5};  // {5,1,2,3,4}; // {2,3,4};  //
        int[] cost = {3,4,5,1,2}; // {4,4,1,5,1}; // {3,4,3};  //
        System.out.println(func3(gas, cost));
    }
}
