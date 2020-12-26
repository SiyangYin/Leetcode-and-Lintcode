import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param k: an integer
     * @param n: an integer
     * @return: return a List[List[int]]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (k > 9) {
            return res;
        }
        
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }
        
        dfs(0, nums, n, k, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int pos, int[] nums, int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k || pos == nums.length) {
            if (n == 0 && cur.size() == k) {
                res.add(new ArrayList<>(cur));
            }
            
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (n >= nums[i]) {
                cur.add(nums[i]);
                dfs(i + 1, nums, n - nums[i], k, cur, res);
                cur.remove(cur.size() - 1);
            } else {
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
    }
}
