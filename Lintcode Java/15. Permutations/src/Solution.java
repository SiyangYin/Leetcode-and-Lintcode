import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = 0; i < nums.length; i++) {
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
        System.out.println(new Solution().permute(new int[0]));
    }
}
