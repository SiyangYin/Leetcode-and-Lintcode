import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: the arrays
     * @param k:    the distance of the same number
     * @return: the ans of this question
     */
    public String sameNumber(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prev = map.get(nums[i]);
                if (i - prev < k) {
                    return "YES";
                }
            }
            
            map.put(nums[i], i);
        }
        
        return "NO";
    }
}
