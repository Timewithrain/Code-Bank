package my.leet;

/** 42. 接雨水 */
public class TrappingRainWater {

    /** 单点计数解法，用时2654ms */
    static int func(int[] height) {
        int l = height.length;
        int ans = 0;
        int max = 0;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, height[i]);
        }
        int[] edgeL = new int[max+1];  // 分别记录每个高度最左和最右的边界
        int[] edgeR = new int[max+1];
        for (int i=1; i<=max; i++) {
            edgeL[i] = edgeR[i] = -1;
            for (int j = 0; j < l; j++) {
                if (edgeL[i]==-1 && height[j]>=i) edgeL[i] = j;  // 记录i高度下的左边界
                if (edgeR[i]==-1 && height[l-1-j]>=i) edgeR[i] = l-1-j;    // 记录i高度下的右边界
                if (edgeL[i]!=-1 && edgeR[i]!=-1) break;
            }
        }
        for (int i = 1; i <= max; i++) {
            for (int j = edgeL[i]; j < edgeR[i]; j++) {  // 两边界之间低于边界的部分即可盛水
                if (height[j] < i) ans++;
            }
        }
        return ans;
    }

    /** 动态规划解法，用时1ms
     * 使用两个数组分别求第i点处左右两边的高度，以较小值为最大容量，减去i处的高度即可得到第i处的容量
     */
    static int func2(int[] height) {
        int ans = 0;
        int l = height.length;
        int[] leftH = new int[l];
        int[] rightH = new int[l];
        for (int i = 1; i < l; i++) {
            leftH[i] = Math.max(leftH[i-1], height[i-1]);
            rightH[l-1-i] = Math.max(rightH[l-i], height[l-i]);
        }
        for (int i = 0; i < l; i++) {
            int maxVol = Math.min(leftH[i], rightH[i]);
            if (maxVol > height[i]) ans += maxVol - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5}; // {0,1,0,2,1,0,1,3,2,1,2,1}; //
        int ans = func(height);
        System.out.println(ans);
        int ans2 = func2(height);
        System.out.println(ans2);
    }
}
