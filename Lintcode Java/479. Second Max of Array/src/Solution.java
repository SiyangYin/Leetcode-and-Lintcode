public class Solution {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // write your code here
        int max1 = nums[0], max2 = nums[1];
        if (max1 < max2) {
            int tmp = max1;
            max1 = max2;
            max2 = tmp;
        }
    
        for (int i = 2; i < nums.length; i++) {
            int n = nums[i];
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        
        return max2;
    }
}
