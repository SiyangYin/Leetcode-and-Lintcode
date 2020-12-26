import java.util.Arrays;

public class Solution {
    /**
     * @param A: a list of integer
     * @return: Return the smallest amplitude
     */
    public int MinimumAmplitude(int[] A) {
        // write your code here
        if (A == null || A.length <= 4) {
            return 0;
        }
        
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            res = Math.min(res, A[r - (3 - i)] - A[l + i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MinimumAmplitude(new int[]{-50, -50, -49, 50, 50, 50}));
    }
}
