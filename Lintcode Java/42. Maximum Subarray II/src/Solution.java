import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int res = Integer.MIN_VALUE, n = nums.size(), cur = 0;
        int[] l = new int[n], r = new int[n];
        l[0] = cur = nums.get(0);
        for (int i = 1; i < n; i++) {
            cur = Math.max(nums.get(i), cur + nums.get(i));
            l[i] = Math.max(l[i - 1], cur);
        }
        r[n - 1] = cur = nums.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            cur = Math.max(nums.get(i), cur + nums.get(i));
            r[i] = Math.max(r[i + 1], cur);
        }
        
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, l[i] + r[i + 1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxTwoSubArrays(Arrays.asList(1, 3, -1, 2, -1, 2)));
    }
}
