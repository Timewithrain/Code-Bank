package my.leet;

/**
 * 383. 赎金信
 */
public class RansomNote {

    static boolean func(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if (map[c-'a']>0) map[c-'a']--;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(func(ransomNote, magazine));
    }
}
