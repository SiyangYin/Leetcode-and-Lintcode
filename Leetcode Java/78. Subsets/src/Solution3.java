import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int start, int[] nums, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, nums, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution3().subsets(nums));
    }
}
