public class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = (int) (1E9 + 7);
        int[] count = {1, 0};
        
        int res = 0;
        for (int i = 0, rem = 0; i < arr.length; i++) {
            rem = (rem + arr[i]) % 2;
            if (rem == 0) {
                res = (res + count[1]) % MOD;
            } else {
                res = (res + count[0]) % MOD;
            }
         
            count[rem]++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[]{1, 3, 5}));
    }
}
