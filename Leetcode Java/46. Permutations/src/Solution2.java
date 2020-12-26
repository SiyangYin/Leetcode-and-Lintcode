import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, cur, 0, res);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> cur, long status, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = 0; i < nums.length; i++) {
            if ((status >> i & 1) == 0) {
                cur.add(nums[i]);
                helper(nums, cur, status + (1 << i), res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().permute(new int[]{1, 2, 3, 4}));
    }
}
