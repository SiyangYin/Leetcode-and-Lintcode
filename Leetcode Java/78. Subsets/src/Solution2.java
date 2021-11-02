import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < 1 << size; i++) {
            List<Integer> list = new ArrayList<>();
            int diff = 0;
            while (1 << diff <= i) {
                if (((i >> diff) & 1) == 1) {
                    list.add(nums[diff]);
                }
                diff++;
            }
            
            res.add(new ArrayList<>(list));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().subsets(new int[]{1, 2, 3}));
    }
}
