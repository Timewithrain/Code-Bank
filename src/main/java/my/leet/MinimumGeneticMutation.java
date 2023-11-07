package my.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/** 433. 最小基因变化 */
public class MinimumGeneticMutation {

    static int dfs(String start, String end, HashMap<String, ArrayList<String>> bankSet, HashSet<String> vis, int cur, int ans) {
        if (start.equals(end)) return cur;
        if (!bankSet.containsKey(start) || vis.contains(start) || cur > ans) return Integer.MAX_VALUE;
        vis.add(start);
        for (String s : bankSet.get(start)) {
            ans = Math.min(ans, dfs(s, end, bankSet, vis, cur+1, ans));
        }
        vis.remove(start);
        return ans;
    }

    static int func(String startGene, String endGene, String[] bank) {
        int ans = Integer.MAX_VALUE;
        HashMap<String, ArrayList<String>> bankSet = new HashMap<>();
        HashSet<String> vis = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            int diff = 0;
            for (int k = 0; k < bank[i].length() && diff <= 1; k++) {
                if (startGene.charAt(k) != bank[i].charAt(k)) diff += 1;
            }
            if (diff == 1) {
                if (!bankSet.containsKey(startGene)) bankSet.put(startGene, new ArrayList<>());
                bankSet.get(startGene).add(bank[i]);
            }
            for (int j = i+1; j < bank.length; j++) {
                diff = 0;
                for (int k = 0; k < bank[i].length() && diff <= 1; k++) {
                    if (bank[i].charAt(k) != bank[j].charAt(k)) diff += 1;
                }
                if (diff == 1) {
                    if (!bankSet.containsKey(bank[i])) bankSet.put(bank[i], new ArrayList<>());
                    if (!bankSet.containsKey(bank[j])) bankSet.put(bank[j], new ArrayList<>());
                    bankSet.get(bank[i]).add(bank[j]);
                    bankSet.get(bank[j]).add(bank[i]);
                }
            }
        }
        ans = dfs(startGene, endGene, bankSet, vis, 0, ans);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT"; // "AACCGGTT"; //
        String endGene = "AAACGGTA"; // "AACCGGTA"; //
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"}; // {"AACCGGTA"}; //
        int ans = func(startGene, endGene, bank);
        System.out.println(ans);
    }
}
