import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    
        int res = -1;
        for (int x : arr) {
            if (map.get(x) == x) {
                res = Math.max(res, x);
            }
        }
        
        return res;
    }
}
