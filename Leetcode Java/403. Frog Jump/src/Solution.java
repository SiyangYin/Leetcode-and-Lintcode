import java.util.*;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        
        int len = stones.length;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dp.put(stones[i], new HashSet<>());
        }
        
        dp.get(stones[0]).add(0);
        
        for (int i = 0; i < len - 1; i++) {
            List<Integer> tmp = new ArrayList<>(dp.get(stones[i]));
            // for (int step : dp.get(stones[i])) {
            for (int step : tmp) {
                for (int dx = -1; dx <= 1; dx++) {
                    int next = stones[i] + step + dx;
                    if (dp.containsKey(next)) {
                        if (next == stones[len - 1]) {
                            return true;
                        }
                        
                        dp.get(next).add(step + dx);
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}
