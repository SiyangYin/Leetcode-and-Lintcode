import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: An Integer array
     * @return: returns the maximum sum of two numbers
     */
    public int MaximumSum(int[] A) {
        // write your code here
        Map<Integer, int[]> map = new HashMap<>();
        for (int a : A) {
            int s = 0, tmp = a;
            while (tmp > 0) {
                s += tmp % 10;
                tmp /= 10;
            }
            
            map.putIfAbsent(s, new int[2]);
            int[] nums = map.get(s);
            if (a > nums[0]) {
                nums[1] = nums[0];
                nums[0] = a;
            } else if (a > nums[1]) {
                nums[1] = a;
            }
        }
    
        int res = -1;
        for (int[] nums : map.values()) {
            if (nums[0] == 0 || nums[1] == 0) {
                continue;
            }
            
            res = Math.max(res, nums[0] + nums[1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MaximumSum(new int[]{51, 71, 17, 42}));
    }
}
