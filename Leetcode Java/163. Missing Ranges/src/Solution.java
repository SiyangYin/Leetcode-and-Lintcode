import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        int start = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                start = nums[i] + 1;
                continue;
            }
            
            if (nums[i] == start + 1) {
                res.add(String.valueOf(start));
                start = nums[i] + 1;
            } else if (nums[i] > start + 1) {
                res.add(start + "->" + (nums[i] - 1));
                start = nums[i] + 1;
            }
        }
        
        if (start == upper) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + upper);
        }
        
        return res;
    }
}
