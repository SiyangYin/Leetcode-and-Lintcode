import java.util.Arrays;

public class Solution2 {
    /**
     * @param nums: an array
     * @return: whether you could make one square using all the matchsticks the little match girl has
     */
    public boolean makesquare(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        sum /= 4;
        if (nums[nums.length - 1] > sum) {
            return false;
        }
        
        return dfs(nums, new boolean[nums.length], 0, sum, 0);
    }
    
    private boolean dfs(int[] nums, boolean[] used, int curSum, int sum, int count) {
        if (count == 4) {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    return false;
                }
            }
            
            return true;
        }
        
        if (curSum == sum && dfs(nums, used, 0, sum, count + 1)) {
            return true;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            if (curSum + nums[i] <= sum) {
                used[i] = true;
                if (dfs(nums, used, curSum + nums[i], sum, count)) {
                    return true;
                }
                used[i] = false;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));
        System.out.println(new Solution2().makesquare(new int[]{10, 10, 10, 10, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6}));
    }
}
