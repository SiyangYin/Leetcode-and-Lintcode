public class Solution {
    /**
     * @param nums: an array
     * @return: if it could become non-decreasing by modifying at most 1 element
     */
    public boolean checkPossibility(int[] nums) {
        // Write your code here
        if (nums.length <= 2) {
            return true;
        }
    
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    count++;
                } else {
                    nums[i + 1] = nums[i];
                    count++;
                }
            }
            
            if (count > 1) {
                return false;
            }
        }
     
        return true;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().checkPossibility(new int[]{4, 2, 1}));
        System.out.println(new Solution().checkPossibility(new int[]{2, 3, 1, 3}));
    }
}
