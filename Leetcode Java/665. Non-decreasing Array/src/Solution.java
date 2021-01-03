public class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        
        boolean changed = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (changed) {
                    return false;
                }
                
                if (i + 1 == nums.length - 1) {
                    return true;
                }
                
                if (nums[i + 1] > nums[i + 2]) {
                    return false;
                } else if (nums[i + 1] < nums[i + 2]) {
                    if (nums[i] <= nums[i + 2]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i + 1];
                    }
                } else {
                    nums[i] = nums[i + 1];
                }
                
                changed = true;
            }
        }
    
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
}
