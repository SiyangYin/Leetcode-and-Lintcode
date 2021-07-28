import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> longestCommomSubsequence(int[][] arrays) {
        int[] cnt = new int[101];
        for (int[] row : arrays) {
            for (int x : row) {
                cnt[x]++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == arrays.length) {
                res.add(i);
            }
        }
        
        return res;
    }
}
