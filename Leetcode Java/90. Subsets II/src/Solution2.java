import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(new ArrayList<>(), 0, nums, res);
        return res;
    }
    
    private void dfs(List<Integer> cur, int pos, int[] nums, List<List<Integer>> res) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        int i = pos + 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
    
        for (int j = 0; j <= i - pos; j++) {
            dfs(cur, i, nums, res);
            cur.add(nums[pos]);
        }
    
        for (int j = 0; j <= i - pos; j++) {
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
