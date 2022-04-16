import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            int hash = hash(dominoe);
            int cnt = map.getOrDefault(hash, 0);
            res += cnt;
            map.put(hash, cnt + 1);
        }
        
        return res;
    }
    
    int hash(int[] p) {
        return p[0] * p[0] * p[0] + p[1] * p[1] * p[1];
    }
}