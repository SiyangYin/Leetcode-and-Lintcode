import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        
        Arrays.sort(copy);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = copy.length - 1; i >= 0; i--) {
            map.put(copy[i], copy.length - i);
        }
        
        String[] res = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            int rank = map.get(nums[i]);
            switch (rank) {
                case 1: res[i] = "Gold Medal"; break;
                case 2: res[i] = "Silver Medal"; break;
                case 3: res[i] = "Bronze Medal"; break;
                default: res[i] = String.valueOf(rank);
            }
        }
        
        return res;
    }
    
    
}
