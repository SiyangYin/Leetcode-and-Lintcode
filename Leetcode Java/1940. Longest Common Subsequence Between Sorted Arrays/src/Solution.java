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
        for (int number = 1; number <= 100; number++) {
            if (cnt[number] == arrays.length) {
                res.add(number);
            }
        }
        
        return res;
    }
}
