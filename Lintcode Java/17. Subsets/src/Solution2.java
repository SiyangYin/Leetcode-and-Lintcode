import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        if (nums == null || nums.length == 0) {
            return res;
        }
    
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                res.add(new ArrayList<>(res.get(j)));
                res.get(res.size() - 1).add(nums[i]);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().subsets(new int[]{1, 2, 3}));
    }
}
