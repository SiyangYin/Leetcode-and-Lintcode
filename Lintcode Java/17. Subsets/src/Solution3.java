import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < 1 << nums.length; i++) {
            int state = i, pos = 0;
            List<Integer> cur = new ArrayList<>();
            while (state != 0) {
                if ((state & 1) == 1) {
                    cur.add(nums[pos]);
                }
                state >>= 1;
                pos++;
            }
            res.add(cur);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().subsets(new int[]{1, 2, 3}));
    }
}
