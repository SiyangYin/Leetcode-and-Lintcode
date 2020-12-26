import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }
    
    private void dfs(int[] nums, List<Integer> cur, boolean[] visited, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, cur, visited, res);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new Solution().permuteUnique(new int[]{3, 3, 0, 3}));
    }
}
