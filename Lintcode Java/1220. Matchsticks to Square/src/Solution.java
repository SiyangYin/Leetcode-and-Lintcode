import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: an array
     * @return: whether you could make one square using all the matchsticks the little match girl has
     */
    
    // 错误代码
    public boolean makesquare(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map);
        if (sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        reverse(nums);
        
        int len = sum / 4;
        if (nums[0] > len) {
            return false;
        }
        
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (!dfs(i, nums, visited, len)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int pos, int[] nums, boolean[] visited, int sum) {
        visited[pos] = true;
        sum -= nums[pos];
        if (sum == 0) {
            return true;
        }
        
        for (int i = pos + 1; i < nums.length; i++) {
            if (sum >= nums[i] && !visited[i]) {
                if (dfs(i, nums, visited, sum)) {
                    return true;
                }
            }
        }
        
        visited[pos] = false;
        return false;
    }
    
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));
        System.out.println(new Solution().makesquare(new int[]{10, 10, 10, 10, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6}));
    }
}
