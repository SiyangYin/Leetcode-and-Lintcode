public class Solution {
    /**
     * @param nums: a integer array
     * @param k: a integer
     * @return: return true or false denoting if the element is present in the array or not
     */
    public boolean findnNumber(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
    
        for (int num : nums) {
            if (num == k) {
                return true;
            }
        }
        
        return false;
    }
}
