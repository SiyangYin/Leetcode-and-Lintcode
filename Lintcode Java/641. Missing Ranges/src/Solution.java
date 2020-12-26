import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                return Arrays.asList(String.valueOf(lower));
            } else {
                return Arrays.asList(lower + "->" + upper);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        if (lower < nums[0]) {
            long l = lower, r = (long) nums[0] - 1;
            if (l == r) {
                res.add(String.valueOf(l));
            } else if (l < r) {
                res.add(l + "->" + r);
            }
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            long l = (long) nums[i] + 1, r = (long) nums[i + 1] - 1;
            if (l == r) {
                res.add(String.valueOf(l));
            } else if (l < r) {
                res.add(l + "->" + r);
            }
        }
        
        if (nums[nums.length - 1] < upper) {
            long l = (long) nums[nums.length - 1] + 1, r = upper;
            if (l == r) {
                res.add(String.valueOf(l));
            } else if (l < r) {
                res.add(l + "->" + r);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMissingRanges(
                new int[]{-2147483648, -2147483648, 0, 2147483647, 2147483647}, -2147483648, 2147483647));
    }
}
