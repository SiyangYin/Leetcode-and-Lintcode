import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: Integer array
     * @param k: a integer
     * @return: return is possible to partition the array satisfying the above conditions
     */
    public boolean PartitioningArray(int[] A, int k) {
        // write your code here
        if (A.length % k != 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int maxOcc = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxOcc = Math.max(maxOcc, entry.getValue());
        }
        
        return maxOcc <= A.length / k;
    }
}
