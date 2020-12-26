import java.util.Collections;
import java.util.List;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        int i = nums.size() - 1;
        while (i > 0 && nums.get(i) >= nums.get(i - 1)) {
            i--;
        }
        
        if (i == 0) {
            Collections.reverse(nums);
            return nums;
        }
        
        Collections.swap(nums, i - 1, binarySearch(nums, i, nums.size() - 1, nums.get(i - 1)));
        int l = i, r = nums.size() - 1;
        while (l < r) {
            Collections.swap(nums, l, r);
            l++;
            r--;
        }
        
        return nums;
    }
    
    private int binarySearch(List<Integer> nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (nums.get(m) < target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
}
