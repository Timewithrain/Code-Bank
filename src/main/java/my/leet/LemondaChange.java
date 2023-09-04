package my.leet;

public class LemondaChange {

    static boolean func(int[] bills) {
        boolean ans = true;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {  // 给5块，不找零
                five += 1;
            } else if (bills[i] == 10) {  // 给10块，找零5块
                if (five > 0) {
                    five -= 1;
                } else {
                    ans = false;
                    break;
                }
                ten += 1;
            } else {    // 给20块，找零15块
                if (ten>0 && five>0) {
                    ten -= 1;
                    five -= 1;
                } else if (five>=3) {
                    five -= 3;
                } else {
                    ans = false;
                    break;
                }
                twenty += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,20}; // {5,5,5,10,20}; // {5,5,10}; // {10,10}; //
        System.out.println(func(bills));
    }
}
