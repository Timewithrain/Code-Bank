package my.leet;

/** 11.盛水最多的容器 */
public class ContainerWithMostWater {

    static int func(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = (j-i) * Math.min(height[i], height[j]);
        while (i<j) {
            if (height[i] < height[j]) i++;
            else j--;
            max = Math.max(max, (j-i) * Math.min(height[i], height[j]));
        }
        return max;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(func(height));

    }
}
