import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.isEmpty()) {
            return;
        }
        
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                flip(nums, 0, i);
                flip(nums, i + 1, nums.size() - 1);
                flip(nums, 0, nums.size() - 1);
            }
        }
    }
    
    private void flip(List<Integer> nums, int i, int j) {
        while (i < j) {
            Collections.swap(nums, i++, j--);
        }
    }
}
