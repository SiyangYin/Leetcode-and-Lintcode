import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    public void dfs(int start, int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(i + 1, nums, list, res, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(new Solution3().subsetsWithDup(nums));
    }
}
