import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param nums: an integer array
     * @return: all the different possible increasing subsequences of the given array
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int pos, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() >= 2) {
            res.add(new ArrayList<>(cur));
        }
        
        if (pos == nums.length) {
            return;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            
            set.add(nums[i]);
            
            if (cur.isEmpty() || nums[i] >= cur.get(cur.size() - 1)) {
                cur.add(nums[i]);
                dfs(i + 1, nums, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 4, 7, 7}));
    }
}
