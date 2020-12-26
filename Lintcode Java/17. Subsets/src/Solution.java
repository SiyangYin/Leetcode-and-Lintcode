import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        if (pos == nums.length) {
            return;
        }
    
        for (int i = pos; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}