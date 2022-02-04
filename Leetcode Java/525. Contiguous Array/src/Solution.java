import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int res = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i] * 2 - 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0}));
    }
}
