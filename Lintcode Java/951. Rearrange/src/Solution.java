import java.util.Arrays;

public class Solution {
    /**
     * @param nums: the num arrays
     * @return: the num arrays after rearranging
     */
    public int[] rearrange(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int l = 0, r = (nums.length + 1) / 2;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[l++];
            } else {
                res[i] = nums[r++];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rearrange(new int[]{-1, 0, 1, -1, 5, 10})));
    }
}
