import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int res = 0;
        
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else {
                res += j - i;
                i++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().twoSum5(new int[]{2, 7, 11, 15}, 24));
    }
}
