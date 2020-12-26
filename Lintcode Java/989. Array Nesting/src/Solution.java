import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param nums: an array
     * @return: the longest length of set S
     */
    public int arrayNesting(int[] nums) {
        // Write your code here
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            
            int cur = nums[i], len = 0;
            while (!set.contains(cur)) {
                set.add(cur);
                cur = nums[cur];
                len++;
            }
            
            res = Math.max(res, len);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}
