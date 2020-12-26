public class Solution {
    public int missingElement(int[] nums, int k) {
        int i = 0;
        while (k > 0) {
            if (i == nums.length - 1) {
                return nums[i] + k;
            }
            
            if (nums[i] + k >= nums[i + 1]) {
                k = k - (nums[i + 1] - nums[i]) + 1;
                i++;
            } else {
                return nums[i] + k;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().missingElement(new int[]{4, 7, 9, 10}, 3));
    }
}
