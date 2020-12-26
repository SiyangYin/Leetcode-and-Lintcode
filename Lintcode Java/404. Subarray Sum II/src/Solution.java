public class Solution {
    /**
     * @param A:     An integer array
     * @param start: An integer
     * @param end:   An integer
     * @return: the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int res = 0;
        if (A[0] >= start && A[0] <= end) {
            res = 1;
        }
        
        int leftSum = A[0], rightSum = A[0];
        for (int j = 1, i1 = 1, i2 = 1; j < A.length; j++) {
            leftSum += A[j];
            rightSum += A[j];
            
            while (i2 < j && leftSum > end) {
                leftSum -= A[i2];
                i2++;
            }
            while (i1 < j && rightSum >= start) {
                rightSum -= A[i1];
                i1++;
            }
            
            if (rightSum >= start && leftSum <= end) {
                res += i1 - i2 + 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(new Solution().subarraySumII(A, 1, 3));
        // int[] A = {1, 2, 3, 4};
        // System.out.println(new Solution().subarraySumII(A, 1, 100));
    }
}
