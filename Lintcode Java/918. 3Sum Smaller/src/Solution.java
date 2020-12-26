import java.util.Arrays;

public class Solution {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 3) {
            return 0;
        }
    
        Arrays.sort(nums);
        
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    res += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
