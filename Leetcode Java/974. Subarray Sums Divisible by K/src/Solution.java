import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0, preSum = 0; i < A.length; i++) {
            preSum = (preSum + A[i] % K + K) % K;
            res += map.getOrDefault(preSum, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        
        return res;
    }
}
