public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                continue;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
        
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2}));
    }
}