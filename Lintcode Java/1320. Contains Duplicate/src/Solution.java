import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param nums: the given array
     * @return: if any value appears at least twice in the array
     */
    public boolean containsDuplicate(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return true;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        return nums.length != set.size();
    }
}
