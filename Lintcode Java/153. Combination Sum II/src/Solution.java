import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
    
        Arrays.sort(num);
        
        dfs(num, target, 0, 0, new ArrayList<>(), res);
        
        return res;
    }
    
    private void dfs(int[] nums, int target, int pos, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            
            if (sum + nums[i] <= target) {
                cur.add(nums[i]);
                dfs(nums, target, i + 1, sum + nums[i], cur, res);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{1, 1, 1, 2}, 3));
        // System.out.println(new Solution().combinationSum2(new int[]{7, 1, 2, 5, 1, 6, 10}, 8));
    }
}