public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int totalSum = 0, sum = 0;
        for (int num : nums) {
            totalSum += num;
        }
    
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == totalSum - sum + nums[i]) {
                return i;
            }
        }
        
        return -1;
    }
}
