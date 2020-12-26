import java.util.Arrays;

public class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int res = -1;
        Arrays.sort(A);
        
        int i = 0, j = A.length - 1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                res = Math.max(res, sum);
                i++;
            } else {
                j--;
            }
        }
        
        return res;
    }
}
