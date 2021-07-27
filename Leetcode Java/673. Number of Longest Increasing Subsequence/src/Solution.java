public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
    
        int max = 1;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    } else if (f[j] + 1 == f[i]) {
                        g[i] += g[j];
                    }
                }
            }
            
            max = Math.max(max, f[i]);
        }
    
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == max) {
                res += g[i];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
