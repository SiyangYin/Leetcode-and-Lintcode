public class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum = nums[i];
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[j - 1]) {
                sum += nums[j];
                j++;
            }
            
            res = Math.max(res, sum);
            sum = 0;
            i = j - 1;
        }
        
        return res;
    }
}
