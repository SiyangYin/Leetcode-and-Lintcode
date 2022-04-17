import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : dominoes) {
            int hash = Math.max(p[0], p[1]) * 10 + Math.min(p[0], p[1]);
            int cnt = map.getOrDefault(hash, 0);
            res += cnt;
            map.put(hash, cnt + 1);
        }
        
        return res;
    }
}