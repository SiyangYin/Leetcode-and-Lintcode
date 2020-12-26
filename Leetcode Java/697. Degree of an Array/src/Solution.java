import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, int[]> map = new HashMap<>();
    
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i});
            } else {
                map.get(nums[i])[1] = i;
            }
        }
        
        int deg = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (val > deg) {
                deg = val;
                list.clear();
                list.add(key);
            } else if (val == deg) {
                list.add(key);
            }
        }
    
        int res = nums.length;
        for (int num : list) {
            int[] idx = map.get(num);
            res = Math.min(res, idx[1] - idx[0] + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
