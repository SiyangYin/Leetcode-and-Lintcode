import java.util.Arrays;

public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    
        for (int i = 0; i < n; i++) {
            nums[i] = (2 * i + 1 - n) * nums[i] - preSum[i] + preSum[n] - preSum[i + 1];
        }
        
        return nums;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getSumAbsoluteDifferences(new int[]{2, 3, 5})));
    }
}
