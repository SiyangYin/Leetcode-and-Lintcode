import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (List<Integer> row : wall) {
            int preSum = 0;
            for (int i = 1; i < row.size() - 1; i++) {
                preSum += row.get(i);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
                cnt = Math.max(cnt, map.get(preSum));
            }
        }
    
        return wall.size() - cnt;
    }
}
