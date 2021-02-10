public class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx < 2 || nums[idx - 1] != nums[i] || nums[idx - 2] != nums[i]) {
                nums[idx++] = nums[i];
            }
        }
        
        return idx;
    }
}
