import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, visited, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int [] nums, int pos, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
    
        for (int i = pos; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, i + 1, visited, cur, res);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
