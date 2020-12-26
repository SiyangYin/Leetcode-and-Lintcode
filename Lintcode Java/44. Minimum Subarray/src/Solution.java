import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int minSum = nums.get(0);
        int[] result = new int[nums.size()];
        result[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result[i] = Math.min(nums.get(i), result[i - 1] + nums.get(i));
            if (result[i] < minSum) {
                minSum = result[i];
            }
        }
        return minSum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArray(new ArrayList<>() {{
            add(1);
            add(-1);
            add(-2);
            add(1);
            add(-4);
        }}));
    }
}