import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        helper(list,nums.length - 1, res);
        return res;
    }
    
    private void helper(List<Integer> list, int pos, List<List<Integer>> res) {
        if (pos == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
    
        for (int i = pos; i >= 0; i--) {
            Collections.swap(list, i, pos);
            helper(list, pos - 1, res);
            Collections.swap(list, i, pos);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
