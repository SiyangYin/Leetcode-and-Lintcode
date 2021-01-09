import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
    
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
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
                dfs(nums, visited, cur, res);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 2, 2}));
    }
}
