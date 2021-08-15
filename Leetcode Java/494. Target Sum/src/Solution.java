import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(0, 0, S, nums, new HashMap<>());
    }
    
    int dfs(int pos, int sum, int target, int[] nums, Map<String, Integer> map) {
        if (pos == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        String key = pos + " " + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        int res = 0;
        res += dfs(pos + 1, sum + nums[pos], target, nums, map);
        res += dfs(pos + 1, sum - nums[pos], target, nums, map);
        map.put(key, res);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
