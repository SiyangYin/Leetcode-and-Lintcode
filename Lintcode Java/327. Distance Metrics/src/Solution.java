import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param a: an integer array
     * @return: an integer array
     */
    public List<Long> getDistanceMetrics(int[] a) {
        // write your code here.
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            res.add(0L);
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.putIfAbsent(a[i], new ArrayList<>());
            map.get(a[i]).add(i);
        }
        
        Map<Integer, long[]> preSums = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() == 1) {
                res.set(list.get(0), 0L);
                continue;
            }
            
            long[] preSum = null;
            if (preSums.containsKey(entry.getKey())) {
                preSum = preSums.get(entry.getKey());
            } else {
                preSum = new long[list.size() + 1];
                for (int i = 0; i < list.size(); i++) {
                    preSum[i + 1] = preSum[i] + list.get(i);
                }
            }
            
            preSums.putIfAbsent(entry.getKey(), preSum);
            
            for (int i = 0; i < list.size(); i++) {
                int pos = list.get(i);
                res.set(pos, (long) pos * i - preSum[i] +
                        (preSum[list.size()] - preSum[i] - (long) pos * (list.size() - i)));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getDistanceMetrics(new int[]{1, 2, 1, 1, 2, 3}));
    }
}
