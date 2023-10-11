package my.leet;

/** 274. H指数 */
public class HIndex {

    static int func(int[] citations) {
        int ans = 0;
        int l = citations.length;
        int max = 0;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, citations[i]);
        }
        int[] arr = new int[max+1];
        for (int i = 0; i < l; i++) {
            for (int j = citations[i]; j >= 0; j--) {
                arr[j]++;
            }
        }
        for (int i = max; i >=  0; i--) {
            if (arr[i] >= i) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] citations = {1}; // {3,0,6,1,5}; // {1,3,1}; //
        int ans = func(citations);
        System.out.println(ans);
    }
}
