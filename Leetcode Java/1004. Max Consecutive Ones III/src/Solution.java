public class Solution {
    public int longestOnes(int[] A, int K) {
        int res = 0, zeroCount = 0;
        for (int i = 0, j = 0; i < A.length; i++) {
            zeroCount += 1 - A[i];
            
            if (zeroCount <= K) {
                res = Math.max(res, i - j + 1);
            } else {
                while (zeroCount > K) {
                    zeroCount -= 1 - A[j];
                    j++;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(new Solution().longestOnes(A, k));
    }
}
