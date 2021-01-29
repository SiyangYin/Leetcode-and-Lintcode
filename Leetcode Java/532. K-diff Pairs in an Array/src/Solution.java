import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
    
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (k > 0 && map.containsKey(key + k)) {
                res++;
            } else if (k == 0 && val > 1) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
    }
}
