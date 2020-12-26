import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int pos, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        
        Set<Integer> used = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                used.add(nums[i]);
                list.add(nums[i]);
                dfs(i + 1, nums, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        // System.out.println(new Solution().findSubsequences(new int[]{4, 6}));
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7}));
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7, 7}));
        // List<List<Integer>> res = new Solution().findSubsequences(nums);
        // System.out.println(res.size());
    }
}
