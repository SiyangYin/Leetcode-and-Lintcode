import java.util.Arrays;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= (i + 1) ^ nums[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{1, 2, 2, 4})));
    }
}
