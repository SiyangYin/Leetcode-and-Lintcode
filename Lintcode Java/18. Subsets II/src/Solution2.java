import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
    
        for (int i = 0; i < 1 << nums.length; i++) {
            Arrays.fill(visited, false);
            int state = i, pos = 0;
            List<Integer> cur = new ArrayList<>();
            boolean valid = true;
            while (state != 0) {
                if ((state & 1) != 0) {
                    cur.add(nums[pos]);
                    visited[pos] = true;
                }
                
                if (pos > 0 && nums[pos] == nums[pos - 1] && !visited[pos - 1] && visited[pos]) {
                    valid = false;
                    break;
                }
                
                pos++;
                state >>= 1;
            }
            
            if (valid) {
                res.add(cur);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().subsetsWithDup(new int[]{1, 1, 2, 2}));
    }
}
