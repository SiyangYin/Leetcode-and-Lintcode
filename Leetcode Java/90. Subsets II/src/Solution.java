import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        return dfs(nums, 0, new ArrayList<>(), res);
    }
    
    private List<List<Integer>> dfs(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(new Solution().subsetsWithDup(nums));
    }
}
