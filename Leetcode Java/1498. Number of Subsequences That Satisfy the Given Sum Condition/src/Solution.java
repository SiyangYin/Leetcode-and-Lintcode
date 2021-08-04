import java.util.Arrays;

public class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length, MOD = (int) (1e9 + 7);
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % MOD;
        }
        Arrays.sort(nums);
        
        int res = 0;
        for (int i = 0, j = n - 1; i < n; i++) {
            while (i <= j && nums[i] + nums[j] > target) {
                j--;
            }
            
            if (i <= j && nums[i] + nums[j] <= target) {
                res = (res + pow[j - i]) % MOD;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(new Solution().numSubseq(new int[]{3, 5, 6, 7}, 9));
    }
}
