import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    
    
    //  这个是错的
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(0, nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int pos, int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                used[i] = true;
                list.add(nums[i]);
                dfs(i + 1, nums, used, list, res);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2, 1, 1};
        // System.out.println(new Solution().findSubsequences(new int[]{4, 6}));
        // System.out.println(new Solution2().findSubsequences(new int[]{4, 6, 7}));
        // System.out.println(new Solution2().findSubsequences(new int[]{4, 6, 7, 7}));
        List<List<Integer>> res = new Solution2().findSubsequences(nums);
        System.out.println(res.size());
        System.out.println(res);
    
        System.out.println(new Solution().findSubsequences(nums));
    }
}
