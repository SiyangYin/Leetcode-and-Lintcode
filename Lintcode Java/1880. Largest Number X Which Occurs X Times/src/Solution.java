import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param arr: an array of integers
     * @return: return the biggest value X, which occurs in A exactly X times.
     */
    public int findX(int[] arr) {
        // write your code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if (k == v) {
                res = Math.max(res, k);
            }
        }
        
        return res;
    }
}
