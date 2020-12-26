import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = Arrays.copyOf(nums, nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            map.putIfAbsent(res[i], i);
        }
    
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums[i]);
        }
        
        return res;
    }
}
